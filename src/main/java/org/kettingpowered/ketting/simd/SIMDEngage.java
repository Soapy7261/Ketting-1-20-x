package org.kettingpowered.ketting.simd;

public class SIMDEngage {
        // Attempt to detect vectorization
        public static void load() {
            try {
                SIMDDetection.isEnabled = SIMDDetection.canEnable(PLogger.LOGGER);
                SIMDDetection.versionLimited = SIMDDetection.getJavaVersion() < 17 || SIMDDetection.getJavaVersion() > 21;
            } catch (NoClassDefFoundError | Exception ignored) {
                ignored.printStackTrace();
            }
            if (SIMDDetection.isEnabled) {
                PLogger.LOGGER.info("SIMD operations detected as functional. Will replace some operations with faster versions.");
            } else if (SIMDDetection.versionLimited) {
                PLogger.LOGGER.warning("Will not enable SIMD! These optimizations are only safely supported on Java 17-21.");
            } else {
                PLogger.LOGGER.warning("SIMD operations are available for your server, but are not configured!");
                PLogger.LOGGER.warning("To enable additional optimizations, add \"--add-modules=jdk.incubator.vector\" to your startup flags, BEFORE the \"-jar\".");
                PLogger.LOGGER.warning("If you have already added this flag, then SIMD operations are not supported on your JVM or CPU.");
                PLogger.LOGGER.warning("Debug: Java: " + System.getProperty("java.version") + ", test run: " + SIMDDetection.testRun);
            }
        }
}