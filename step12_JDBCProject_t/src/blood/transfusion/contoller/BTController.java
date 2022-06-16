package blood.transfusion.contoller;

import java.sql.SQLException;
import java.util.ArrayList;

import blood.transfusion.dto.BTProjectDTO;
import blood.transfusion.dto.DonorDTO;
import blood.transfusion.dto.RecipientDTO;
import blood.transfusion.exception.NotExistException;
import blood.transfusion.model.BTProjectDAO;
import blood.transfusion.model.BTService;
import blood.transfusion.model.DonorDAO;
import blood.transfusion.view.RunningEndView;
//import blood.transfusion.view.RunningSuccessView;

public class BTController {
	private static BTController instance = new BTController();
	private BTService service = BTService.getInstance();
	
	private BTController() {}
	
	public static BTController getInstance() {
		return instance;
	}
	
	// 모든 프로젝트 검색
	public void allBTProjects(){
		try{
			RunningEndView.projectListView(service.getAllBTProjects());
//			RunningSuccessView.showSuccess("모든 프로젝트 검색 성공");
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든 프로젝트 검색시 에러 발생");
		}
	
	}
	
	// 특정 프로젝트 검색
	public void BTProject(String btProjectName) {
		try {
			RunningEndView.projectView(service.getBTProject(btProjectName));		
		} catch(SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("프로젝트 검색시 에러 발생");
		} catch(NotExistException n) {
			n.printStackTrace();
			RunningEndView.showError("프로젝트 없음");
		}
	}
	
	// 새로운 프로젝트 저장 로직
	public void insertBTProject(BTProjectDTO btProject, DonorDTO donor, RecipientDTO recipient) {
		try {
//			service.addDonor(donor);
//			service.addRecipient(recipient);
			service.addBTProject(btProject, donor, recipient);
		} catch(SQLException s) {
			s.printStackTrace();
		} catch (NotExistException n) {
			n.printStackTrace();
		}
	}
	
	// 특정 프로젝트 업데이트
	public void updateBTProject(String btProjectId, String btProjectContent) {
		try {
			service.updateBTProject(btProjectId, btProjectContent);
			RunningEndView.successUpdate();
		} catch(SQLException s) {
			s.printStackTrace();
		} catch(NotExistException n) {
			n.printStackTrace();
		}
	}
	
	// 특정 프로젝트 삭제
	public void deleteBTProject(BTProjectDTO btProject) {
		try {
			service.deleteBTProject(btProject.getBtProjectId());
//			service.deleteDonor(btProject.getDonorId());
//			service.deleteRecipient(btProject.getRecipientId());
			RunningEndView.successDelete();
		} catch(SQLException s) {
			s.printStackTrace();
		} catch(NotExistException n) {
			n.printStackTrace();
		}
	}
	
	// 모든 헌혈자 검색 로직
	public static ArrayList<DonorDTO> getAllDonors(){
		ArrayList<DonorDTO> allProject = null;
		try{
			RunningEndView.projectListView(DonorDAO.getAllDonors());
//			RunningSuccessView.showSuccess("모든  헌혈자 검색 성공");
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("모든  헌혈자 검색시 에러 발생");
		}
		return allProject;
	}
	
}
