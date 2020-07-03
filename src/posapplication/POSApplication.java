package posapplication;


import Models.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.List;

public class POSApplication extends Application {

    private TableView<User> table = new TableView<>();
    private ObservableList<User> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {

        User userModel = new User();
        List<User> users = userModel.getUsers();
        for(User user: users){
            data.add(user);
        }


        Scene scene = new Scene(new Group());
        stage.setTitle("Users DB App");
        stage.setWidth(1920);
        stage.setHeight(1080);

        final Label label = new Label("Users Table");
        label.setFont(new Font("Arial", 16));

        table.setEditable(false);

        TableColumn colId = new TableColumn("ID");
        colId.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));

        TableColumn colFirstName = new TableColumn("First name");
        colFirstName.setCellValueFactory(new PropertyValueFactory<User, String>("fname"));
        colFirstName.setMinWidth(100);

        TableColumn colLastName = new TableColumn("Last name");
        colLastName.setCellValueFactory(new PropertyValueFactory<User, String>("lname"));
        colLastName.setMinWidth(100);

        TableColumn colUsername = new TableColumn("Username");
        colUsername.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        colUsername.setMinWidth(100);

        table.setItems(data);
        table.getColumns().addAll(colId, colFirstName, colLastName, colUsername);


        Button button = new Button("Alamakota");

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label,table,button);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);


        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
