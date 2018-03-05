node {
    		stage('Checkout and Test') {
                  Checkout scm //checks out the code based on the last commit
        		echo 'Building....'
                  Sh “””oc process simple-mongodb-api-controller.json -p [parameters]| oc apply -f - | oc start-build”””
                  //’oc apply’ will create the objects or configure them if already created
                  //start-build will start the build and unit tests in openshift. 
    		}
    	}
