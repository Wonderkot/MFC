/**
 * 
 */
package ru.pfr.udm.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.pfr.udm.services.MfcDataService;
import ru.pfr.udm.services.MfcServiceService;
import ru.pfr.udm.services.UserService;
import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.MfcData;
import ru.udm.pfr.models.MfcService;
import ru.udm.pfr.models.User;

/**
 * @author pd199717
 *
 */
@RestController
public class PageController {
	private static Logger log = LogManager.getLogger(PageController.class);
	@Autowired
	MfcServiceService mfcService;
	@Autowired
	MfcDataService mfcDataService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/valuesOfMfc", method=RequestMethod.GET)
	public String showMfcInput(Model model) {
		List<MfcService> mfcServices =  mfcService.getServiceList();
		
		//TODO переделать
		User user = new User();	
		user.setName("pd199717");
		Mfc district =  userService.getDistrict(user).get(0);
		
		List<MfcData> mfcDatas = mfcDataService.getOldValues(district.getId()); 
		model.addAttribute("services", mfcServices);
		model.addAttribute("values", mfcDatas);
		return "mfc";		
	}
	
	
}
