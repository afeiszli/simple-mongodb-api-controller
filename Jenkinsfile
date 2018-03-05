node {
    		stage('Checkout and Test') {

		checkout scm
        	def flag = true;
            
            	def branch = BRANCH_NAME.toLowerCase();
           	def source = BRANCH_NAME
           	if (branch.contains('/')){
                	branch = branch.substring(branch.lastIndexOf("/") + 1)
           	}                  


                  sh """oc process -f simple-mongodb-api-controller.json -p NAME=$branch -lapp=$branch | oc apply -f -"""
		  sh """oc start build $branch"""
                  //’oc apply’ will create the objects or configure them if already created
                  //start-build will start the build and unit tests in openshift. 
    		}
    	}
