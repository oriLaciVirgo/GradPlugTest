package hu.virgo.plugin

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project;

class GradPlug implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def hasApp = project.plugins.withType(AppPlugin)
        def hasLib = project.plugins.withType(LibraryPlugin)

        if (!hasApp && !hasLib) {
            throw new IllegalStateException("'android' or 'android-plugin' library required")
        }

        def log = project.logger
        def variants = hasApp ? project.android.applicationVariants : project.android.libraryVariants

        project.dependencies {
            
            compile 'org.aspectj:aspectjrt:1.8.6'
        }

/*        final def log = project.logger
        final def variants
        if (hasApp) {
            variants = project.android.applicationVariants
        } else {
            variants = project.android.libraryVariants
        }

        project.dependencies {
      debugCompile 'com.jakewharton.hugo:hugo-runtime:1.2.2-SNAPSHOT'
      // TODO this should come transitively
      debugCompile 'org.aspectj:aspectjrt:1.8.5'
      compile 'com.jakewharton.hugo:hugo-annotations:1.2.2-SNAPSHOT'
    }

*/
    }
}