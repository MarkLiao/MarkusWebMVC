markusWebAppModule.controller('homeController', function($http, $scope, $rootScope, $parse){	
	
	var getSkillList = function(){
		$http.get("/MarkusWeb/Home/getSkillList", {}).then(function(payload){
			if(payload != null){
				$scope.skills = payload.data;
			}
		});
	};
	
	var getHomePageContent = function(){
		
		$http.get("/MarkusWeb/loadTitles/" + "Home", {}).then(function(payload){
			if(payload.data != null){
				setScope(payload.data);
			}
		});
	};
		
	var setScope = function(dataMap){
		Object.keys(dataMap).forEach(function(key){
			$parse(key).assign($scope, dataMap[key]);
		});
	};
	
	
	getSkillList();
	getHomePageContent();
	
	
	$scope.goToLinkedIn = function(){
		//this scope variable comes from the database
		window.location=href = $scope.externalLinkedInPath;
	};
});