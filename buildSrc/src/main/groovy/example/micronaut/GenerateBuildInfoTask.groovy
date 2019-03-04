package example.micronaut
import org.gradle.api.*
import org.gradle.api.tasks.*

class GenerateBuildInfoTask extends DefaultTask {

    @OutputFile
    def File outputFile

    @InputFile
    def File inputFile

    @TaskAction
    def generate() {
        println 'hello from GenerateBuildInfoTask'
        Properties props = new Properties()
        props.load(inputFile.newDataInputStream())

        Properties outputProps = new Properties()
        outputProps.setProperty("version", props.get("projectVersion"))
        outputProps.store(outputFile.newOutputStream(), "")
    }
}