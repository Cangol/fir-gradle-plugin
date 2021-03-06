package im.fir.gradle

import com.android.build.gradle.api.ApplicationVariant
import im.fir.gradle.http.FirClient
import im.fir.gradle.module.App
import org.gradle.api.DefaultTask

class FirPublishTask extends DefaultTask {
    FirPublisherPluginExtension firExtension
    BugHdPublisherPluginExtension bugHdExtension
    FirClient client
    ApplicationVariant variant
    App app

    def publish() {
        if (client == null) {
            client = FirPublisherHelper.init(firExtension)
        }
        app = new App()
        app.setBundleId(variant.applicationId)
        app.setAppType("android")
        app.setBuild(variant.versionCode + "")
        app.setVersion(variant.versionName)
    }
}