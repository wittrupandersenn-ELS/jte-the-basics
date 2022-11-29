fields {
    required { }
    optional {
        /*
         * Custom arguments to add to general maven commands (e.g. not tests) for this specific project.
         * The pipeline default is used if this is not set.
         */
        arguments = String


        /*
         * Path where the pom.xml file for general commands (e.g. not tests) is stored relative to the root of the repository.
         * The pipeline default is used if this is not set.
         */
        pomPath = String

        /*
         * Name of the Maven settings.xml configuration file ID in Jenkins to use for this specific project.
         * The pipeline default is used if this is not set.
         */
        settingId = String
    }
}
