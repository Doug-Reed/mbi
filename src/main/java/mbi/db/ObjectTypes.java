package mbi.db;

public enum ObjectTypes {
    EVENT ("events"),
    PLAYER ("players"),
    RESPONSE ("responses");

   
        private String filename;
        private ObjectTypes (String filename) {
            this.filename = filename;
        }

        public String getFilename(){
            return this.filename;
        }

}