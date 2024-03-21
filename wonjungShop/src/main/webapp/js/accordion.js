function ToggleAccordion(sideMenu) {
			var content = sideMenu.nextElementSibling;
			if (content.style.display === "block") {
				content.style.display = "none";
			} else {
				content.style.display = "block";
			}
		}