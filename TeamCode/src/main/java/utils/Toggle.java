package utils;



public class Toggle
{
    private boolean state = false;

    private boolean curr = false;
    private boolean prev = false;


    /***
     *
     * @param newState
     * @return returns true if state was just toggled, false if it stayed the same
     */
    public boolean update(boolean newState)
    {
        prev = curr;
        curr = newState;

        if(curr && !prev) //this means that an entire click has to be performed in order to change the state
        {
            state = !state;

            return true; //this way, the method will only return true if the button was only just toggled on, this denotes a state change
        }

        return false;
    }

    public void print()
    {

    }

    /**
     * Returns the state of the toggle
     * @return
     */
    public boolean getState()
    {
        return state;
    }

    /**
     * Wrapper method for getState()
     * @return
     */
    public boolean active()
    {
        return getState();
    }

    public void reset()
    {
        state = false;
        curr = false;
        prev = false;
    }

}
