<<<<<<< HEAD
package telecommande.javafx.view;

import telecommande.javafx.view.ManagerGuiAbstract.RunnableWithException;

public interface IManagerGui {

	void launch( String titre );

	void showView(EnumView view);

	void reinit();

	void close();

	void execTask( RunnableWithException runnable );

	void afficherMessage(String message);

	void afficherErreur(Throwable exception);

	void afficherErreur(String message);

	void afficherErreur(String message, Throwable exception);

	boolean demanderConfirmation(String message);

=======
package telecommande.javafx.view;

import telecommande.javafx.view.ManagerGuiAbstract.RunnableWithException;

public interface IManagerGui {

	void launch( String titre );

	void showView(EnumView view);

	void reinit();

	void close();

	void execTask( RunnableWithException runnable );

	void afficherMessage(String message);

	void afficherErreur(Throwable exception);

	void afficherErreur(String message);

	void afficherErreur(String message, Throwable exception);

	boolean demanderConfirmation(String message);

>>>>>>> 8db2a1bbb19125a2c2e94e2e523eef8498e32271
}