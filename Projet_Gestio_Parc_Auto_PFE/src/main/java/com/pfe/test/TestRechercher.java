package com.pfe.test;
import java.util.List;
import com.pfe.dao.RepPanneHome;
import com.pfe.persistance.RepPanne;
import com.pfe.services.RepPanneService;
public class TestRechercher {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CompteService dao = new CompteService();
      //  Compte cmp = new Compte();
      //  ConnectBean cnt = new ConnectBean();
      //  cnt.connecter();
        //System.out.println(cmp.getMotDePasse());
         // else  System.out.println("compte nexiste pas");
		RepPanneHome rep = new RepPanneHome();
		RepPanneService repserv = new RepPanneService();
		List<RepPanne> liste = null;
		liste= repserv.rechercheRep_PanParPanne(1);
		for(int i=0;i<liste.size();i++)
				System.out.print(liste.get(i).getIdRepPanne());
		
	}
}
