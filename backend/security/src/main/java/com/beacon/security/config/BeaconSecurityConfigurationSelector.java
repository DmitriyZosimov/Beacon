package com.beacon.security.config;

import com.beacon.security.annotation.EnableBeaconSecurity;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class BeaconSecurityConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(EnableBeaconSecurity.class.getName(), false)
        );
        Application application = attributes.getEnum("application");
        switch (application) {
            case CATALOG: return new String[] {"com.beacon.security.config.CatalogSecurityResourceServerConfig"};
            case SEARCH: return new String[] {"com.beacon.security.config.SearchSecurityResourceServerConfig"};
            case SHOP: return new String[] {"com.beacon.security.config.ShopSecurityResourceServerConfig"};
            default: return new String[]{};
        }
    }
}
