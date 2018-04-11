package telecommande.javafx.model;


public interface IContextModel {

	<T> T getModel(Class<T> type);

}