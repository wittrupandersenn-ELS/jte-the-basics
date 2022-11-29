package steps
/*
 * Releases the compiled Java package using Maven Release plugin
 *
 *
 * Function type: pipeline
 * Function arguments: none
 * Library parameters used:
 *  - arguments
 *  - pomPath
 *  - settingId
 *
 * Pipeline parameters used:
 *  - defaults.maven.arguments
 *  - defaults.maven.pomPath
 *  - defaults.maven.settingId
 *
 * Environment variables used:
 *  - mavenContainer
 *
 * Environment variables set: none
 */

void call() {
    /*
     * Set variables
     */
    String arguments = config.arguments ?: defaults?.maven?.arguments ?: ''
    String pomPath   = config.pomPath ?: defaults?.maven?.pomPath ?: '.'

    /*
     * Part of the step execution that will visualised as a Jenkins stage
     */
    stage('Release') {
        run_inside env.mavenContainer, {
            configFileProvider([configFile(fileId: (config.settingId ?: defaults?.maven?.settingId), variable: 'MAVEN_SETTINGS')]) {
                sh "mvn -B -s $MAVEN_SETTINGS -f ${pomPath}/pom.xml release:prepare release:perform -DskipTests ${arguments}"
            }
        }
    }
}
