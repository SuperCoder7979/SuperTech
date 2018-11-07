package supercoder79.supertech.api.random;

public class ItsNotMyFaultException extends RuntimeException {
    private String mError;

    public ItsNotMyFaultException(String aError) {
        mError = aError;
    }

    @Override
    public String toString() {
        return "SuperTech ran into a major problem. Here is the error: " + mError + "Usually this is caused by addons. If you do not have any addons installed, please contact SuperCoder79.";
        //return "The GregTech-Addon has a Problem.\nIT'S NOT MY FAULT!!! Below is how to fix it.\n" + mError + "\nDO NOT COME TO ME WITH THIS CRASH. YOU CAUSED IT YOURSELF, AND I TOLD YOU HOW TO FIX IT!!!";
    }
}
