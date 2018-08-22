/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import dao.CinemaDAO;
import dao.SallesDAO;
import metier.Cinema;
import metier.Salle;
import panels.PanelImportSalle;

/**
 *
 * @author Bastien
 */
public class EvtImportSalle implements ActionListener {

	PanelImportSalle importer;

	public EvtImportSalle(PanelImportSalle panelImportSalle) {
		this.importer = panelImportSalle;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == importer.getBtRetour()) {
			showadminpage();
		} else if (e.getSource() == importer.getBtImporter()) {
			importxml();
		} else if (e.getSource() == importer.getBtParcourir()) {
			parcourir();
		} else if (e.getSource() == importer.getBtValider()) {
			importersalle();
		}
	}

	public void showadminpage() {
		importer.getCinego().getCl().show(importer.getCinego().getContent(), "Admin");
	}

	@SuppressWarnings("rawtypes")
	public void importxml() {
		Document document = new Document();
		Element racine;
		String fichierimport = importer.getPath();
		int nbsiege = 0;
		int crangee = 0;
		int crangeeh = 0;

		SAXBuilder sxb = new SAXBuilder();
		try {
			document = sxb.build(new File(fichierimport));
		} catch (JDOMException | IOException e) {
		}

		racine = document.getRootElement();

		List<Element> typeEcran = racine.getChildren("typedecran");
		XMLOutputter outEcran = new XMLOutputter();
		String sE = outEcran.outputString(typeEcran);
		String[] ecranSplit = sE.split(">");
		String[] ecranSplit1 = ecranSplit[1].split("<");
		importer.setTbTypeEcran(ecranSplit1[0]);

		List<Element> typeSon = racine.getChildren("typedeson");
		XMLOutputter outSon = new XMLOutputter();
		String sS = outSon.outputString(typeSon);
		String[] sonSplit = sS.split(">");
		String[] sonSplit1 = sonSplit[1].split("<");
		importer.setTbTypeSon(sonSplit1[0]);

		List<Element> numSalle = racine.getChildren("numerosalle");
		XMLOutputter outNum = new XMLOutputter();
		String sN = outNum.outputString(numSalle);
		String[] numSplit = sN.split(">");
		String[] numSplit1 = numSplit[1].split("<");
		importer.setTbNumSalle(numSplit1[0]);

		List<Element> nomSalle = racine.getChildren("nomdesalle");
		XMLOutputter outNom = new XMLOutputter();
		String sNS = outNom.outputString(nomSalle);
		String[] nomSplit = sNS.split(">");
		String[] nomSplit1 = nomSplit[1].split("<");
		importer.setTbNomSalle(nomSplit1[0]);

		List<Element> cineR = racine.getChildren("cinema");
		XMLOutputter outCine = new XMLOutputter();
		String sC = outCine.outputString(cineR);
		String[] cineSplit = sC.split(">");
		String[] cineSplit1 = cineSplit[1].split("<");
		importer.setTbCineRattach(cineSplit1[0]);

		List listesalle = racine.getChildren("rangee");
		Iterator irangee = listesalle.iterator();
		while (irangee.hasNext()) {
			Element rangeeactuelle = (Element) irangee.next();
			crangee++;
			List listesiege = rangeeactuelle.getChildren("siege");
			Iterator isiege = listesiege.iterator();
			while (isiege.hasNext()) {
				Element siegeactuel = (Element) isiege.next();
				System.out.println(siegeactuel.getText());
				nbsiege++;
			}
		}
		List listesalleh = racine.getChildren("rangeeh");
		Iterator irangeeh = listesalleh.iterator();
		while (irangeeh.hasNext()) {
			crangeeh++;
			Element rangeeactuelle = (Element) irangeeh.next();
			List listesiege = rangeeactuelle.getChildren("siege");
			Iterator isiege = listesiege.iterator();
			while (isiege.hasNext()) {
				Element siegeactuel = (Element) isiege.next();
				System.out.println(siegeactuel.getText());
				nbsiege++;
			}
		}
		importer.setTbNbPlaces(String.valueOf(nbsiege));
		importer.setTbNbRangees(String.valueOf(crangee));
		importer.setTbNbPlacesH(String.valueOf(crangeeh));
	}

	public void parcourir() {
		importer.setImportEnable(false);
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("Fichier XML (*.xml)", "xml");
		chooser.setFileFilter(xmlfilter);
		chooser.setApproveButtonText("Sélectionner");
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			importer.setPath(chooser.getSelectedFile().getAbsolutePath());
			importer.setImportEnable(true);
		}
	}

	public void importersalle() {
		Salle salle = new Salle();
		SallesDAO salledao = new SallesDAO();
		CinemaDAO cinedao = new CinemaDAO();
		Cinema cine = new Cinema();
		cine = cinedao.findByNom(importer.getTbCineRattach());
		salle.setNbPlacesTotal(Integer.parseInt(importer.getTbNbPlaces()));
		salle.setNbRangées(Integer.parseInt(importer.getTbNbRangees()));
		salle.setNbSiegeHandi(Integer.parseInt(importer.getTbNbPlacesH()));
		int nbSiegeParRangees = Integer.parseInt(importer.getTbNbPlaces()) / Integer.parseInt(importer.getTbNbRangees())
				+ 1;
		salle.setNbSiegeRangées(nbSiegeParRangees);
		salle.setNuméro(Integer.parseInt(importer.getTbNumSalle()));
		salle.setCinema(cine);
		salle.setTypeEcran(importer.getTbTypeEcran());
		salle.setTypeSon(importer.getTbTypeSon());
		Salle importsalle = new Salle();
		importsalle = salledao.saveOrUpdate(salle);
		if (importsalle == null) {
			JOptionPane.showMessageDialog(importer, "Problème pendant l'import de la salle.");
		} else {
			JOptionPane.showMessageDialog(importer, "La salle a été correctement importée.");
			importer.setValidEnable(true);
		}
	}

}
