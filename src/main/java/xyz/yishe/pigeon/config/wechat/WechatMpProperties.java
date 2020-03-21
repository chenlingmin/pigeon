package xyz.yishe.pigeon.config.wechat;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "wechat.mp")
public class WechatMpProperties {
    /**
     * app-id
     */
    private String appId;

    /**
     * secret
     */
    private String secret;
}
