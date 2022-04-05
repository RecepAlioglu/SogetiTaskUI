package SogetiAutomation.model;

    public enum ResultColor {
        RED("#ff304c"),BlUE("#0070ad");

        String code;

        ResultColor(String c){
            this.code=c;
        }

        public String getCode(){
            return code;
        }

        public boolean matchesCode(String c){
            return this.code.equals(c);
        }

        public static ResultColor getFromCode(String code){
            if (code==null){
                return null;
            }
            for (ResultColor c:ResultColor.values()){
                if (c.matchesCode(code)){
                    return c;
                }
            }

            return null;
        }
}
