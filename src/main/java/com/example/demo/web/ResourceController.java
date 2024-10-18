package com.example.demo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.AnnexeRepository;
import com.example.demo.dao.CitoyenRepository;
import com.example.demo.dao.EndroitRepository;
import com.example.demo.dao.RueRepository;
import com.example.demo.dao.RuelleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Annexe;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Citoyen;
import com.example.demo.entities.CustomAnnexeResponse;
import com.example.demo.entities.CustomRueResponse;
import com.example.demo.entities.CustomRuelleResponse;
import com.example.demo.entities.CustomUserResponse;
import com.example.demo.entities.Endroit;
import com.example.demo.entities.Rue;
import com.example.demo.entities.Ruelle;
import com.example.demo.services.AccountService;
import com.example.demo.services.ReportService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin("*")
@RestController
public class ResourceController {

	@Autowired
	EndroitRepository endroitsrRepository;

	@Autowired
	AnnexeRepository annexeRepository;
	@Autowired
	UserRepository userRepository;

	@Autowired
	ReportService reportService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@GetMapping("/endroits2")
	public List<Endroit> getAllBenificiaires(){
		return endroitsrRepository.findAll();
	}
	@GetMapping("/allAAL")
	public List<Annexe> getAllAAL(){
		return annexeRepository.findAll();
	}
	 @GetMapping(path = "/photoUser/{id}", produces = {org.springframework.http.MediaType.IMAGE_JPEG_VALUE, org.springframework.http.MediaType.IMAGE_PNG_VALUE})
	public byte[] getPhoto(@PathVariable("id") int id)throws Exception{
		AppUser u = userRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/attestations/"+u.getPhotoName()));
		
	}
	@PostMapping("/report5")
	public void generateReport5(@RequestBody Map<String, String> request, HttpServletResponse response) throws JRException, IOException {
	    
	    String role = request.get("role");
	    String pachalik = request.get("pachalik");
	    String district = request.get("district");
	    String annexe = request.get("annexe");
	    String count = request.get("count");
	    String dataJson = request.get("data");
	    List<AppUser> data = new ObjectMapper().readValue(dataJson, new TypeReference<List<AppUser>>(){});
	  reportService.exportReport3("pdf", data, "C:\\allProjects3.jrxml",role,pachalik,district,annexe,count, response);
	}

	
	@PostMapping(path = "/uploadPhoto/{id}")
	public void uploadPhoto(MultipartFile file,@PathVariable int id) throws Exception {
		AppUser u = userRepository.findById(id).get();
		u.setPhotoName(id+".png");
		Files.write(Paths.get(System.getProperty("user.home")+"/attestations"), file.getBytes());
	
	}
	@PostMapping(path = "/uploadPhoto")
	public void uploadPhoto(
	    @RequestPart("file") MultipartFile file,
	    @RequestPart("userObject") String userObjectJson
	) throws Exception {
	    // Convert the JSON string to your User object
	    ObjectMapper objectMapper = new ObjectMapper();
	    AppUser u = objectMapper.readValue(userObjectJson, AppUser.class);

	    // Check if the user has an ID
	    if (u.getId() != null) {
	        // Retrieve the existing user from the repository
	        Optional<AppUser> existingUserOptional = userRepository.findById(u.getId());

	        if (existingUserOptional.isPresent()) {
	            // Update the existing user's details
	            AppUser existingUser = existingUserOptional.get();
	            existingUser.setFirstNameAr(u.getFirstNameAr());
	            existingUser.setFirstNameFr(u.getFirstNameFr());
	            existingUser.setLastNameAr(u.getLastNameAr());
	            existingUser.setLastNameFr(u.getLastNameFr());
	          
	                existingUser.setUsername(u.getUsername());
	      
	            existingUser.setRole(u.getRole());  // Assuming Role is an enum or a valid type
	           
	                existingUser.setPhone(u.getPhone());
	 
	                existingUser.setEmail(u.getEmail());
	     
	            existingUser.setJob(u.getJob());
	      
	                existingUser.setCin(u.getCin());
	        

	            // Check if the password is provided in the update request
	            if (u.getPassword() != null) {
	                String hashPW = bCryptPasswordEncoder.encode(u.getPassword());
	                existingUser.setPassword(hashPW);
	            }

	            // Save or update the user details in the database
	         
	           

	            // Save the user's photo
	            existingUser.setPhotoName(existingUser.getId() + ".jpg");
	            userRepository.save(existingUser);
	            Files.write(Paths.get(System.getProperty("user.home") + "/attestations/" + existingUser.getPhotoName()), file.getBytes());

	            // You can return something here if needed
	            return;
	        }
	    }

	    // If no ID or user not found, save a new user
	    if (u.getPassword() != null) {
	        String hashPW = bCryptPasswordEncoder.encode(u.getPassword());
	        u.setPassword(hashPW);
	    }

	    AppUser savedUser = userRepository.save(u);

	    // Set the photoName using the ID of the saved user
	    savedUser.setPhotoName(savedUser.getId() + ".jpg");

	    // Save or update the user details in the database
	    userRepository.save(savedUser);

	    // Save the user's photo
	    Files.write(Paths.get(System.getProperty("user.home") + "/attestations/" + savedUser.getPhotoName()), file.getBytes());
	}
	
	
	
	@Autowired
	CitoyenRepository citoyenRepository;
	
	@PostMapping(path = "/uploadPhotoCitoyen")
	public void uploadPhotoCitoyen(
			   @RequestPart(value = "file", required = false) MultipartFile file, 
			    @RequestPart(value = "fileExtrait", required = false) MultipartFile fileExtrait,
			    @RequestPart(value = "fileCin1", required = false) MultipartFile fileCin1,
			    @RequestPart(value = "fileCin2", required = false) MultipartFile fileCin2,
	    @RequestPart("userObject") String citoyenObjectJson
	) throws Exception {
	    // Convert the JSON string to your User object
	    ObjectMapper objectMapper = new ObjectMapper();
	    Citoyen u = objectMapper.readValue(citoyenObjectJson, Citoyen.class);

	    // Check if the user has an ID
	    if (u.getId() != null) {
	        // Retrieve the existing user from the repository
	        Optional<Citoyen> existingUserOptional = citoyenRepository.findById(u.getId());

	        if (existingUserOptional.isPresent()) {
	            // Update the existing user's details
	            Citoyen existingUser = existingUserOptional.get();
	            existingUser.setFirstNameAr(u.getFirstNameAr());
	            existingUser.setFirstNameFr(u.getFirstNameFr());
	            existingUser.setLastNameAr(u.getLastNameAr());
	            existingUser.setLastNameFr(u.getLastNameFr());
	           
	                     
	                existingUser.setPhone(u.getPhone());
	 
	                existingUser.setEmail(u.getEmail());
	     
	            existingUser.setJob(u.getJob());
	      
	                existingUser.setCin(u.getCin());
	        existingUser.setDistrict(u.getDistrict());
	        existingUser.setAnnexe(u.getAnnexe());
	        existingUser.setPachalik(u.getPachalik());
	        existingUser.setRue(u.getRue());
	        existingUser.setRuelle(u.getRuelle());
	        existingUser.setQuartier(u.getQuartier());

	          
	    	System.out.println("$$$$$$$$$$$$$$$$$$$");

setImages(existingUser, file,fileExtrait,fileCin1,fileCin2);
citoyenRepository.save(existingUser);

	            // You can return something here if needed
	            return;
	        }
	    }
	    System.out.println("$$$$$$$$$$$$$$$$$$$3");
	
	   Citoyen savedUser = citoyenRepository.save(u);

	    setImages(savedUser, file,fileExtrait,fileCin1,fileCin2);

	    // Save or update the user details in the database
	    citoyenRepository.save(savedUser);


	}

public void setImages(Citoyen existingUser,   @RequestPart("file") MultipartFile file, @RequestPart("fileExtrait") MultipartFile fileExtrait,
	    @RequestPart("fileCin1") MultipartFile fileCin1,
	    @RequestPart("fileCin2") MultipartFile fileCin2) throws IOException {
	if(file!=null) {
		   // Save the user's photo
	    existingUser.setPhotoName(existingUser.getId() + ".jpg");
	    
	    Files.write(Paths.get(System.getProperty("user.home") + "/attestations/" + existingUser.getPhotoName()), file.getBytes());
	}
		
	if(fileExtrait!=null) {
		   // Save the user's photo
	 existingUser.setActeNaissance(existingUser.getId() + ".jpg");
	 
	 Files.write(Paths.get(System.getProperty("user.home") + "/acteNaissance/" + existingUser.getActeNaissance()), fileExtrait.getBytes());
	}
	if(fileCin1!=null) {
		   // Save the user's photo
	existingUser.setCin1(existingUser.getId() + ".jpg");

	Files.write(Paths.get(System.getProperty("user.home") + "/cin1/" + existingUser.getCin1()), fileCin1.getBytes());
	}
	if(fileCin2!=null) {
		   // Save the user's photo
	existingUser.setCin2(existingUser.getId() + ".jpg");

	Files.write(Paths.get(System.getProperty("user.home") + "/cin2/" + existingUser.getCin2()), fileCin2.getBytes());
	}
}

	   @Autowired
	    private AnnexeRepository annexRepository; // Assuming you have an AnnexRepository

	    //@GetMapping("/districts2/{districtId}/annexes")
	    //public ResponseEntity<CustomAnnexeResponse> getAnnexesPaged(
	      //      @PathVariable Integer districtId,
	   // @RequestParam(defaultValue = "0") int page,
	   //   @RequestParam(defaultValue = "10") int size) {

	   // PageRequest pageRequest = PageRequest.of(page, size);
	   // Page<Annexe> annexPage = annexRepository.findAnnexesByDistrictId(districtId, pageRequest);

	   // CustomAnnexeResponse response = new CustomAnnexeResponse();
	   // response.setAnnexes(annexPage.getContent());
	   // response.setTotalElements(annexPage.getTotalElements());

	   // return ResponseEntity.ok(response);
	   // }
	    @Autowired
	    private RueRepository rueRepository; // Assuming you have an AnnexRepository

	    @GetMapping("/quartiers2/{quartierId}/rues")
	    public ResponseEntity<CustomRueResponse> getRuesPaged(
	            @PathVariable Integer quartierId,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {

	        PageRequest pageRequest = PageRequest.of(page, size);
	        Page<Rue> annexPage = rueRepository.findRuesByQuartierId2(quartierId, pageRequest);

	        CustomRueResponse response = new CustomRueResponse();
	        response.setRues(annexPage.getContent());
	        response.setTotalElements(annexPage.getTotalElements());

	        return ResponseEntity.ok(response);
	    }
	    
	    @Autowired
	    private RuelleRepository ruelleRepository; // Assuming you have an AnnexRepository

	    @GetMapping("/rues2/{rueId}/ruelles")
	    public ResponseEntity<CustomRuelleResponse> getRuesllePaged(
	            @PathVariable Integer rueId,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {

	        PageRequest pageRequest = PageRequest.of(page, size);
	        Page<Ruelle> annexPage = ruelleRepository.findRuellesByRueId2(rueId, pageRequest);

	        CustomRuelleResponse response = new CustomRuelleResponse();
	        response.setRuelles(annexPage.getContent());
	        response.setTotalElements(annexPage.getTotalElements());

	        return ResponseEntity.ok(response);
	    }


		   @Autowired
		    private UserRepository userrRepository; // Assuming you have an AnnexRepository

		    @GetMapping("/roles2/{roleId}/users")
		    public ResponseEntity<CustomUserResponse> getUsersPaged(
		            @PathVariable Integer roleId,
		            @RequestParam(defaultValue = "0") int page,
		            @RequestParam(defaultValue = "10") int size) {

		        PageRequest pageRequest = PageRequest.of(page, size);
		        Page<AppUser> userPage = userrRepository.findAppUsersByRoleId(roleId, pageRequest);

		        CustomUserResponse response = new CustomUserResponse();
		        response.setAppUsers(userPage.getContent());
		        response.setTotalElements(userPage.getTotalElements());

		        return ResponseEntity.ok(response);
		    }

		    @GetMapping("/annexes2/{annexeId}/users")
		    public ResponseEntity<CustomUserResponse> getUsersPagedByAnnexe(
		            @PathVariable Integer annexeId,
		            @RequestParam(defaultValue = "0") int page,
		            @RequestParam(defaultValue = "10") int size) {

		        PageRequest pageRequest = PageRequest.of(page, size);
		        Page<AppUser> userPage = userrRepository.findAppUsersByAnnexeId(annexeId, pageRequest);

		        CustomUserResponse response = new CustomUserResponse();
		        response.setAppUsers(userPage.getContent());
		        response.setTotalElements(userPage.getTotalElements());

		        return ResponseEntity.ok(response);
		    }

		    @Autowired
		    private AccountService accountService;

		    @PostMapping("/register")
		    public AppUser registerUser(@RequestBody AppUser user) {
		        // Call the service method to save the user
		        return accountService.save(user);
		    }
		    @PostMapping("/registerCitoyen")
		    public Citoyen registerCitoyen(@RequestBody Citoyen user) {
		        // Call the service method to save the user
		    	System.out.println(user.getPachalik()+"$$$$$$$$$$$$$$$$$$$");
		        return citoyenRepository.save(user);
		    }
		    @PostMapping("/update-password/{userId}")
		    public ResponseEntity<String> updatePassword(@PathVariable Integer userId, @RequestBody String newPassword) {
		        
		        
		        try {
		            accountService.updatePassword(userId, newPassword);
		            return ResponseEntity.ok("Password updated successfully");
		        } catch (IllegalArgumentException e) {
		            return ResponseEntity.badRequest().body(e.getMessage());
		        }
		    }
	 
}