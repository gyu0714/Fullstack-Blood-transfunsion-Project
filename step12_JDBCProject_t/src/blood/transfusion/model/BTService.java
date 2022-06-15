package blood.transfusion.model;

import java.sql.SQLException;
import java.util.ArrayList;

import blood.transfusion.dto.BTProjectDTO;
import blood.transfusion.dto.DonorDTO;
import blood.transfusion.dto.RecipientDTO;
import blood.transfusion.exception.NotExistException;

public class BTService {
			
	private static BTService instance = new BTService();
	
	private BTService(){}
	
	public static BTService getInstance(){
		return instance;
	}
	
	//BTProject - CRUD
	public void notExistBTProject(String btProjectId) throws NotExistException, SQLException{
		BTProjectDTO btProject = BTProjectDAO.getBTProject(btProjectId);
		if(btProject == null){
			throw new NotExistException("검색하신 수혈 정보가 없습니다.");
		}
	}
	
	//모든 BTProject 정보 반환
	public ArrayList<BTProjectDTO> getAllBTProjects() throws SQLException{
		return BTProjectDAO.getAllBTProjects();
	}
	
	//BTProject 이름로 검색
	public BTProjectDTO getBTProject(String btProjectName) throws SQLException, NotExistException{
		return BTProjectDAO.getBTProject(btProjectName);
	}
	
	//새로운 BTProject 저장
	public boolean addBTProject(BTProjectDTO btProject) throws NotExistException, SQLException{
			return BTProjectDAO.addBTProject(btProject);
		}
		
	
	//기존 BTProject 수정
	public boolean updateBTProject(String btProjectId, String btProjectContent) throws SQLException, NotExistException{
		notExistBTProject(btProjectId);
		return BTProjectDAO.updateBTProject(btProjectId, btProjectContent);
	}
	
	//BTProject 삭제
	public boolean deleteBTProject(String btProjectId) throws SQLException, NotExistException{
		notExistBTProject(btProjectId);
		return BTProjectDAO.deleteBTProject(btProjectId);
	}
	
	
	//Donor - CRUD
	public void notExistDonor(String donorId) throws NotExistException, SQLException {
		DonorDTO Donor = DonorDAO.getDonor(donorId);
		if (Donor == null) {
			throw new NotExistException("검색한  헌혈자가 미 존재합니다.");
		}
	}

	public boolean addDonor(DonorDTO donor) throws NotExistException, SQLException {
		return DonorDAO.addDonor(donor);
	}

	public boolean updateDonor(String donorId, String purposeDonation) throws SQLException, NotExistException {
		notExistDonor(donorId);
		return DonorDAO.updateDonor(donorId, purposeDonation);
	}

	public boolean deleteDonor(String donorId) throws SQLException, NotExistException {
		notExistDonor(donorId);
		return DonorDAO.deleteDonor(donorId);
	}

	public DonorDTO getDonor(String donorId) throws SQLException, NotExistException {
		DonorDTO donor = DonorDAO.getDonor(donorId);
		if (donor == null) {
			throw new NotExistException("검색한 헌혈자가 미 존재합니다.");
		}
		return donor;
	}

	public ArrayList<DonorDTO> getAllDonors() throws SQLException {
		return DonorDAO.getAllDonors();
	}

	// Recipient - CRUD
	public static void notExistRecipient(String recipientId) throws NotExistException, SQLException {
		RecipientDTO recipient = RecipientDAO.getRecipient(recipientId);
		if (recipient == null) {
			throw new NotExistException("검색한  수혈자가 미 존재합니다.");
		}
	}

	public static boolean addRecipient(RecipientDTO recipient) throws NotExistException, SQLException {
		return RecipientDAO.addRecipient(recipient);
	}

	public static boolean updateRecipient(String recipientId, String purposeTransfusion)
			throws SQLException, NotExistException {
		notExistRecipient(recipientId);
		return RecipientDAO.updateRecipient(recipientId, purposeTransfusion);
	}

	public boolean deleteRecipient(String recipientId) throws SQLException, NotExistException {
		notExistRecipient(recipientId);
		return RecipientDAO.deleteRecipient(recipientId);
	}

	public static RecipientDTO getRecipient(String recipientId) throws SQLException {
		return RecipientDAO.getRecipient(recipientId);
	}

	public static ArrayList<RecipientDTO> getAllRecipients() throws SQLException {
		return RecipientDAO.getAllRecipients();
	}
}
