package im.fir.gradle

import com.android.build.gradle.AppPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class FirPublisherPlugin implements Plugin<Project> {

    public static final String FIR_IM_GROUP = "fir.im"

    @Override
    void apply(Project project) {
        def log = project.logger

        def hasAppPlugin = project.plugins.find { p -> p instanceof AppPlugin }
        if (!hasAppPlugin) {
            throw new IllegalStateException("The 'com.android.application' plugin is required.")
        }

        def firExtension = project.extensions.create('fir', FirPublisherPluginExtension)
        def bugHdExtension = project.extensions.create('bughd', BugHdPublisherPluginExtension)

        project.android.applicationVariants.all { variant ->
            if (firExtension == null) {
                log.error("Please config your fir.im apiToken in your build.gradle.")
                return
            }
            def buildTypeName = variant.buildType.name.capitalize()

            def productFlavorNames = variant.productFlavors.collect { it.name.capitalize() }
            if (productFlavorNames.isEmpty()) {
                productFlavorNames = [""]
            }
            def productFlavorName = productFlavorNames.join('')
//                def flavor = StringUtils.uncapitalize(productFlavorName)

            def variationName = "${productFlavorName}${buildTypeName}"

//                def bootstrapTaskName = "bootstrap${variationName}PlayResources"
//                def playResourcesTaskName = "generate${variationName}PlayResources"
            def publishApkTaskName = "publishFirApk${variationName}"
            def outputData = variant.outputs.first()
            def assembleTask = variant.assemble

            def variantData = variant.variantData

            //log.warn("variantData.zipAlignEnabled === >" + variantData.zipAlignEnabled);
            //if (variantData.zipAlignEnabled) {
            // Create and configure publisher apk task for this variant.
            log.info("publishApkTaskName === " + publishApkTaskName)

            def publishApkTask = project.tasks.create(publishApkTaskName, FirPublishApkTask)
            publishApkTask.firExtension = firExtension
            if (bugHdExtension.apiToken != null && bugHdExtension.projectId != null) {
                log.info("bugHdExtension === bugHdExtension not null")
                publishApkTask.bugHdExtension = bugHdExtension
            }
            publishApkTask.variant = variant
            publishApkTask.description = "Uploads the APK for the ${variationName} build"
            publishApkTask.group = FIR_IM_GROUP
            publishApkTask.dependsOn assembleTask
//                } else {
//                log.warn("Could not find ZipAlign task. Did you specify a signingConfig for the variation ${variationName}?")
//            }
        }
    }

}
