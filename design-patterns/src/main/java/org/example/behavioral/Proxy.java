package org.example.behavioral;

interface OfficeNetAccess{
    public void grantNetAccess();
}

class RealNetAccess implements OfficeNetAccess{
    private String ename;

    public RealNetAccess(String ename){
        this.ename = ename;
    }

    @Override
    public void grantNetAccess() {
        System.out.println("Access granted to employee "+ename);
    }
}

class ProxyNetAccess implements OfficeNetAccess{
    private String ename;
    private RealNetAccess realNetAccess;

    public ProxyNetAccess(String ename){
        this.ename=ename;
    }

    public int getRole(String ename){
        return ename.length();
    }

    @Override
    public void grantNetAccess() {
        if(getRole(ename) > 4){
            realNetAccess = new RealNetAccess(ename);
            realNetAccess.grantNetAccess();
        }
        else
            System.out.println("Access not granted. Your job level is below 5");
    }
}
public class Proxy {
    public static void main(String args[]){
        OfficeNetAccess officeNetAccess = new ProxyNetAccess("muskan");
        officeNetAccess.grantNetAccess();
    }
}
