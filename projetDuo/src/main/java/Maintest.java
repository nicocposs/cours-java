import org.formation.hibernate.entity.Conseiller;
import org.formation.service.IService;
import org.formation.service.ServiceImpl;

public class Maintest {

	public static void main(String[] args) {
		

//		
//		
//		Conseiller c = new Conseiller("luc", "Lucky", LocalDate.of(2022, 7, 1), 1800, null);
//		IDao dao = new Dao();
//
//		Conseiller c2 = new Conseiller("luc", "Lucky", LocalDate.of(2022, 7, 1), 1800, null);
//
//		dao.add(c2);
//		
//		System.out.println(dao.find(1));		
//		Conseiller cc = dao.find(2);
//		
//		cc.setName("jean-luc");
//		
//		dao.update(cc);		
//		List<Conseiller> listC = dao.findAll();
//		for (Conseiller conseiller : listC) {
//			System.out.println(conseiller);
//		}		
//
		
//		System.out.println(new ServiceImpl().getConseiller(2));
		
		
		IService service = new ServiceImpl();
		Conseiller c = service.getConseiller(2);
		c.setName("dude");
		service.updateConseiller(c);
		
	}

}
	
