package xyz.yishe.pigeon.config.support;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.yishe.pigeon.common.exception.BizException;
import xyz.yishe.pigeon.common.model.page.DirectionEnum;
import xyz.yishe.pigeon.common.model.page.PageQuery;
import xyz.yishe.pigeon.common.model.page.Sort;
import xyz.yishe.pigeon.common.util.CommonUtils;

import java.sql.SQLSyntaxErrorException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 一句话功能简述
 *
 * @author panjianguo 2018-11-16 下午1:30
 */
@Slf4j
@Aspect
@Component
public class MyBatisPageSupport {
    @Pointcut("execution(public xyz.yishe.pigeon.common.model.page.PageResult xyz.yishe.pigeon.core.impl.*.*(..))")
    public void pageAspect() {

    }

    @Around(value = "pageAspect()")
    public Object mybatisPage(ProceedingJoinPoint pjp) throws Throwable {
        PageQuery pageQuery = (PageQuery) pjp.getArgs()[0];

        // 组装排序信息
        StringBuilder orderByBuf = new StringBuilder();
        Sort sort = pageQuery.getSort();
        if (CommonUtils.isNotEmpty(sort) && CommonUtils.isNotEmpty(sort.getOrderBy())) {
            Map<String, DirectionEnum> orderMap = sort.getOrderBy();
            orderByBuf.append(
                    orderMap.entrySet()
                            .stream()
                            .map(e -> e.getKey().concat(" ").concat(e.getValue().getDirection()))
                            .collect(Collectors.joining(","))
            );
        }

        try {
            // 分页
            xyz.yishe.pigeon.common.model.page.Page page = pageQuery.getPage();
            Page<Object> pageHelper = PageHelper.startPage(page.getStartIndex(), page.getPageSize());

            // 排序
            String orderBy = orderByBuf.toString();
            if (orderBy.length() > 0) {
                pageHelper.setOrderBy(orderBy);
            }

            return pjp.proceed();
        } catch (SQLSyntaxErrorException sqle) {
            throw new BizException("SQL语法错误！e:{}", sqle);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BizException("分页查询出错！");
        }
    }
}
