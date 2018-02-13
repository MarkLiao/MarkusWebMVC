markusWebAppModule.controller('hobbyController', function($scope, $http, $parse){
	var getHobbyPageContent = function(){
		$http.get("/MarkusWeb/loadTitles/" + "Hobbies", {}).then(function(payload){
			if(payload.data != null){
				setScope(payload.data);
			}
		});
		
		$http.get("/MarkusWeb/Hobbies/routineList", {}).then(function(payload){
			if(payload){
				$scope.daysOfWeek = payload.data;
			}
		});
		
		$http.get("/MarkusWeb/Hobbies/prStatList", {}).then(function(payload){
			if(payload){
				$scope.activityList = payload.data;
			}
		});
	};
		
	var setScope = function(dataMap){
		Object.keys(dataMap).forEach(function(key){
			$parse(key).assign($scope, dataMap[key]);
		});
	};
	
	getHobbyPageContent();
});