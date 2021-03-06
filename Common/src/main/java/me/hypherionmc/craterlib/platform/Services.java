package me.hypherionmc.craterlib.platform;

import me.hypherionmc.craterlib.CraterConstants;
import me.hypherionmc.craterlib.platform.services.LibClientHelper;

import java.util.ServiceLoader;

public class Services {

    //public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static final LibClientHelper CLIENT_HELPER = load(LibClientHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        CraterConstants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
