package Controller;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Alertsmaker {
 
	public static void alertmmaterial1(StackPane root, Node nodetobeblured, List<JFXButton> controls, String header,String body) {
		 BoxBlur blur=new BoxBlur(3,3,3);			
			
	        JFXDialogLayout dialogLayout =new JFXDialogLayout();
	       dialogLayout.getStyleClass().add("stack");
	       dialogLayout.getStylesheets().add("/CSS/alertclair.css");
	        JFXDialog dialog = new JFXDialog(root, dialogLayout,JFXDialog.DialogTransition.CENTER); 
	        
	        controls.forEach(controlbutton ->{
	        	 controlbutton.getStylesheets().add("/CSS/alertclair.css");
	        	controlbutton.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent) ->{
		        	dialog.close();
		        	}); 
	        });
	        
	dialogLayout.setHeading(new Label (header));
	dialogLayout.setBody(new Label(body));
	dialogLayout.setActions(controls);
	dialog.show();
	dialog.setOnDialogClosed((JFXDialogEvent event1) ->{
		nodetobeblured.setEffect(null);
	});
	
	nodetobeblured.setEffect(blur);
	}
	public static void alertmmaterial2(StackPane root, Node nodetobeblured, List<JFXButton> controls, String header,String body) {
					
			
	        JFXDialogLayout dialogLayout =new JFXDialogLayout();
	       dialogLayout.getStyleClass().add("stack");
	       dialogLayout.getStylesheets().add("/CSS/alertclair.css");
	        JFXDialog dialog = new JFXDialog(root, dialogLayout,JFXDialog.DialogTransition.CENTER); 
	        
	        controls.forEach(controlbutton ->{
	        	 controlbutton.getStylesheets().add("/CSS/alertclair.css");
	        	controlbutton.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent) ->{
		        	dialog.close();
		        	}); 
	        });
	        
	dialogLayout.setHeading(new Label (header));
	dialogLayout.setBody(new Label(body));
	dialogLayout.setActions(controls);
	dialog.show();
	dialog.setOnDialogClosed((JFXDialogEvent event1) ->{
		nodetobeblured.setEffect(null);
	});
	
	
	}
	
}
