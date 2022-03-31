// @author Max Reulet

package parkingappcalculations;


public class Preferences {
    
    private final User userName;
    private final String parkPass;
    private final int speed;
    private final String[] schedule;
    
   private Preferences(UserBuilder builder) {
       this.userName = builder.userName;
       this.parkPass = builder.parkPass;
       this.speed = builder.speed;
       this.schedule = builder.schedule;
   }
   
   public User getUserName() {
       return userName;
   }
   
   public String addPass () {
        return parkPass;
    }
    
    public int addWalkSpeed() {
        return speed;
    }
    
    public String[] classSchedule() {
        return schedule;
    }
    
    public static class UserBuilder {
        private final User userName;
        private String parkPass;
        private int speed;
        private String[] schedule;
        
        public UserBuilder(User userName) {
            this.userName = userName;
        }
        
        public UserBuilder parkPass(String parkPass) {
            this.parkPass = parkPass;
            return this;
        }
        
        public UserBuilder speed(int speed) {
            this.speed = speed;
            return this;
        }
        
        public UserBuilder schedule(String[] schedule) {
            this.schedule = schedule;
            return this;
        }
        
        public Preferences build() {
            Preferences currentUser = new Preferences(this);
            return currentUser;
        }
    }    
}
