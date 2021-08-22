import com.intellij.execution.process.mediator.daemon.DaemonLaunchOptions;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;


public class GotestAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        boolean flag = false;
        Runtime rt = Runtime.getRuntime();
        Process p = null;

        DaemonLaunchOptions.HandshakeOption.File f = new DaemonLaunchOptions.HandshakeOption.File("covertarget");
        /*if(!f.exists()){
            f.mkdirs();
        }*/
        System.out.println("�й�");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(f.getPath());

        int exitVal;
        try {

            p = rt.exec("cd D:\\workspace\\unittest\\go_project\\");
            exitVal = p.waitFor();

            p = rt.exec("go test -v ./src/... -coverprofile=coverprofile2.cov");
            //0 ִ�гɹ�
            exitVal = p.waitFor();
            Messages.showInfoMessage("go test sucess ִ�гɹ�","gout");
        } catch (Exception ex) {
            ex.printStackTrace();
            Messages.showInfoMessage("go test fail ִ��ʧ��","gout");

        }


    }
}
