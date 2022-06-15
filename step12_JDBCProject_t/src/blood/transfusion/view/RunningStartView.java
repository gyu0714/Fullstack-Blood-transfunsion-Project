package blood.transfusion.view;

import blood.transfusion.contoller.BTController;
import blood.transfusion.dto.BTProjectDTO;
import blood.transfusion.dto.DonorDTO;
import blood.transfusion.dto.RecipientDTO;

public class RunningStartView {

	public static void main(String[] args) {
		BTController controller = BTController.getInstance();
		
		System.out.println("=====모든 프로젝트 검색=====");
		controller.allBTProjects();

//		System.out.println("=====프로젝트 등록=====");
//		controller.insertBTProject(new BTProjectDTO("C-", "bt3", "donor3", "recipient3","O-형간의 수혈"),
//				new DonorDTO("donor3", "헌혈3", 35, "F", "O-", "봉사"),
//				new RecipientDTO("recipient3", "수혈3", 3, "M", "O-", "질병"));
				
		
		System.out.println("=====프로젝트 검색=====");
		controller.BTProject("bt1");
		
//		System.out.println("=====프로젝트 수정=====");
//		controller.updateBTProject("bt1", "I wanna go home");
		
		System.out.println("=====프로젝트 삭제=====");
		controller.deleteBTProject(new BTProjectDTO("C-", "bt3", "donor3", "recipient3","O-형간의 수혈"));
	}
}
