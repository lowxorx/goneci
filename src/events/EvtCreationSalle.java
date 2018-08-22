package events;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import panels.PanelCreationSalle;

public class EvtCreationSalle implements ActionListener {
	PanelCreationSalle newsalle;

	public EvtCreationSalle(PanelCreationSalle panelGestionSalles) {
		this.newsalle = panelGestionSalles;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newsalle.getBtRetour()) {
			showadminpage();
		} else if (e.getSource() == newsalle.getBtCreerSalle()) {
			creersalle();

		} else if (e.getSource() == newsalle.getBtResetFields()) {
			resetfields();
		} else if (e.getSource() == newsalle.getBtExportSalle()) {
			System.out.println("coucou");
			exportsalle(Integer.parseInt(newsalle.getTbNbPlaces()), Integer.parseInt(newsalle.getTbNbRangees()),
					Integer.parseInt(newsalle.getTbNbPlacesH()), Integer.parseInt(newsalle.getTbNumSalle()),
					newsalle.getSelectedTypeEcran(), newsalle.getSelectedTypeSon(), newsalle.getTbNomSalle(),
					newsalle.getSelectedCineR());
		}
	}

	public void showadminpage() {
		newsalle.getCinego().getCl().show(newsalle.getCinego().getContent(), "Admin");
	}

	public void resetfields() {
		newsalle.setTbNbPlaces("");
		newsalle.setTbNbPlacesH("");
		newsalle.setTbNbRangees("");
		newsalle.setTbNomSalle("");
		newsalle.setTbNumSalle("");
	}

	public void creersalle() {
		newsalle.getSelectedCineR();
		newsalle.getTbNbPlaces();
		newsalle.getTbNbRangees();
		newsalle.getTbNbPlacesH();
		newsalle.getSelectedTypeSon();
		newsalle.getSelectedTypeEcran();

	}

	public void exportsalle(int nbsiege, int nbrangees, int nbsiegeh, int numsalle, String typedecran, String typedeson,
			String nomsalle, String cineRattach) {
		try {
			Element rootElement = new Element("Salle");
			Document doc = new Document(rootElement);

			Element typescreen = new Element("typedecran");
			typescreen.setText(typedecran);
			rootElement.addContent(typescreen);

			Element numdesalle = new Element("numerosalle");
			numdesalle.setText(Integer.toString(numsalle));
			rootElement.addContent(numdesalle);

			Element nomdesalle = new Element("nomdesalle");
			nomdesalle.setText(nomsalle);
			rootElement.addContent(nomdesalle);

			Element cinemarattach = new Element("cinema");
			cinemarattach.setText(cineRattach);
			rootElement.addContent(cinemarattach);

			Element typesound = new Element("typedeson");
			typesound.setText(typedeson);
			rootElement.addContent(typesound);

			// Calcul du nombre de sièges par rangées
			int nbspr = nbsiege / nbrangees;
			System.out.println("sieges par rangées : " + nbspr);

			Element rangeeh = new Element("rangeeh");
			rootElement.addContent(rangeeh);
			for (int countsiegesh = 1; countsiegesh <= nbsiegeh; countsiegesh++) {
				Element siege = new Element("siege");
				String numsiege = "HA" + Integer.toString(countsiegesh);
				rangeeh.addContent(siege.setText(numsiege));
			}

			for (int countrangee = 1; countrangee <= nbrangees; countrangee++) {
				Element rangee = new Element("rangee");
				rootElement.addContent(rangee);
				for (int countsieges = 1; countsieges <= nbspr; countsieges++) {
					Element siege = new Element("siege");
					String numsiege = "R" + Integer.toString(countrangee) + "S" + Integer.toString(countsieges);
					rangee.addContent(siege.setText(numsiege));
				}
			}
			String result = "C:/cinego/" + nomsalle + ".xml";

			try {
				XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
				java.io.FileWriter writer = new java.io.FileWriter(result);
				sortie.output(doc, writer);
				writer.flush();
				writer.close();

			} catch (java.io.IOException e) {
				System.out.println("erreur output" + e);
			}
			System.out.println("File saved!");

			int selectedOption = JOptionPane.showConfirmDialog(newsalle, "Voulez vous afficher le fichier ?",
					"Choississez", JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				try {
					Desktop desk = Desktop.getDesktop();
					desk.open(new File("C:/cinego/" + nomsalle + ".xml"));
				} catch (java.io.IOException e) {
					System.out.println("erreur affichage" + e);
				}
			}

		} catch (Exception e) {
			System.out.println("erreur générale" + e);
		}
	}

}
