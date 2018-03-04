import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger( Main.class.getName() );
    private static String workingDir;
    public static OS getMachineOS() {
        return machineOS;
    }

    public enum OS{
        MAC, WINDOWS
    }
    private static OS machineOS;

    public static void main(String[] args) {
        setMachineOS();
        InitLogger.init();
        logger.log(Level.FINE, "working in machine os " + getMachineOS());
    }
//
//    public String runProcess(long timeout, String... args){
//        final RunResult result = new RunResult();
//        ProcessBuilder pb = new ProcessBuilder(commands);
//        pb.directory(dir);
//        pb.environment().putAll(environment);
//        pb.redirectErrorStream(true);
//        final Process process = pb.start();
//        _log.debug("+ Currently running adb processes: " + (countAdbProcesses.incrementAndGet()));
//        result.process = process;
//        if (timeout > 0) {
//            BackgroundTasks.getInstance().schedule(
//                    "Kill process after " + timeout, new Runnable() {
//                        @Override
//                        public void run() {
//                            String cmd = "";
//                            try {
//                                cmd = Arrays.toString(Arrays.copyOfRange(commands,1,commands.length));
//                            } catch (Exception e) {
//                                cmd = Arrays.toString(commands);
//                            }
//                            _log.debug("adb kill process " + cmd + " after "+timeout);
//                            process.destroy();
//                            _log.debug("- Currently running adb processes: " + (countAdbProcesses.decrementAndGet()));
//                        }
//                    }, timeout, TimeUnit.MILLISECONDS);
//        }
//        StringBuilder buf = new StringBuilder();
//
//        try (InputStreamReader in = new InputStreamReader (result.process.getInputStream (), "UTF-8");
//             BufferedReader reader = new BufferedReader (in)) {
//            String readLine = null;
//            while ((readLine = reader.readLine ()) != null) {
//                buf.append (readLine);
//                buf.append ("\n");
//            }
//        }
//        result.result = buf.toString();
//        // LogUtils.createLog(InstrumentationUtils.class).debug(result);
//        return result;
//    }
    private static void setMachineOS(){
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            machineOS = OS.WINDOWS;
        }
        else{
            machineOS = OS.MAC;
        }
    }
    public String getWorkingDir(){
        return workingDir;
    }
    public void setWorkingDir(){
        workingDir =  System.getProperty("user.dir");
    }
}
