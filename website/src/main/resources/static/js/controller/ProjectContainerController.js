markusWebAppModule.controller('projectController', function($http, $scope, $rootScope, $parse){	
	var getProjectPageContent = function(){
		
		$http.get("/MarkusWeb/loadTitles/" + "Project", {}).then(function(payload){
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
	
	
	getProjectPageContent();
	
	
	$scope.selectedTab=0;
	
	//this section is to show the enlarged pictures
	$scope.showElement = false;
	$scope.enlargeImg = function($event){
		$scope.showElement=true;
		$scope.selectedImgUrl = $event.currentTarget.src;
	};
	
	$scope.close = function(){
		$scope.showElement=false;
	};
	
	$scope.changeIndex = function(index){
		$scope.selectedTab=index;
	}
});