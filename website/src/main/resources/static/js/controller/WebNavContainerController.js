markusWebAppModule.controller('webAppNavController', function($http, $rootScope, $scope){	
	$scope.currentNavItem = "homePage";
	$scope.selectedNav = "Home/HomeContainer";
	$scope.changeContainer = function(changeTo){
		$scope.currentNavItem = changeTo;
		if(changeTo ==="homePage"){
			$scope.selectedNav="Home/HomeContainer";
			$scope.currentNavItem = "homePage";
		}else if (changeTo === "projectPage"){
			$scope.selectedNav = "Project/ProjectContainer";
			$scope.currentNavItem = "projectPage";
		}else if (changeTo === "hobbyPage"){
			$scope.selectedNav = "Hobbies/HobbiesContainer";
			$scope.currentNavItem = "hobbyPage";
		}
	}
});