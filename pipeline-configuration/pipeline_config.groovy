libraries{
    maven
}

keywords{
  develop = ~/^[Dd]ev(elop|elopment|eloper|)$/
  main = ~/^[Mm](ain|aster)$/
    defaults {
      maven {
                /*
                 * Name of the Maven global settings.xml configuration file ID in Jenkins
                 */
                settingId = 'maven-settings-institutional-integrations-platform'
            }
    }
}
