package tk.ystyle.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 小奕 on 2014-06-30 9:17.
 */
public class Order implements Serializable{
    private static final long serialVersionUID = -4402392412217726259L;
    private int type;
    private double price;
    private String apuser;
    private String approveuser;
    private boolean isNote;
    private Date crtime;
    private String cruser;
    private String crusno;
    private String retono;
    private String whcode;
    private String orderno;
    private String storecode;
    private String expresscode;
    private String expressnumber;
    private String mobile;
    private String consigneeaddress;
    private String consigneename;
    private String shopcode;
    private String shopname;
    private String tradeid;
    private double receivedfee;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getApuser() {
        return apuser;
    }

    public void setApuser(String apuser) {
        this.apuser = apuser;
    }

    public String getApproveuser() {
        return approveuser;
    }

    public void setApproveuser(String approveuser) {
        this.approveuser = approveuser;
    }

    public boolean isNote() {
        return isNote;
    }

    public void setNote(boolean isNote) {
        this.isNote = isNote;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getCrusno() {
        return crusno;
    }

    public void setCrusno(String crusno) {
        this.crusno = crusno;
    }

    public String getRetono() {
        return retono;
    }

    public void setRetono(String retono) {
        this.retono = retono;
    }

    public String getWhcode() {
        return whcode;
    }

    public void setWhcode(String whcode) {
        this.whcode = whcode;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getStorecode() {
        return storecode;
    }

    public void setStorecode(String storecode) {
        this.storecode = storecode;
    }

    public String getExpresscode() {
        return expresscode;
    }

    public void setExpresscode(String expresscode) {
        this.expresscode = expresscode;
    }

    public String getExpressnumber() {
        return expressnumber;
    }

    public void setExpressnumber(String expressnumber) {
        this.expressnumber = expressnumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getConsigneeaddress() {
        return consigneeaddress;
    }

    public void setConsigneeaddress(String consigneeaddress) {
        this.consigneeaddress = consigneeaddress;
    }

    public String getConsigneename() {
        return consigneename;
    }

    public void setConsigneename(String consigneename) {
        this.consigneename = consigneename;
    }

    public String getShopcode() {
        return shopcode;
    }

    public void setShopcode(String shopcode) {
        this.shopcode = shopcode;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getTradeid() {
        return tradeid;
    }

    public void setTradeid(String tradeid) {
        this.tradeid = tradeid;
    }

    public double getReceivedfee() {
        return receivedfee;
    }

    public void setReceivedfee(double receivedfee) {
        this.receivedfee = receivedfee;
    }

    @Override
    public String toString() {
        return "Order{" +
                "type=" + type +
                ", price=" + price +
                ", apuser='" + apuser + '\'' +
                ", approveuser='" + approveuser + '\'' +
                ", isNote=" + isNote +
                ", crtime=" + crtime +
                ", cruser='" + cruser + '\'' +
                ", crusno='" + crusno + '\'' +
                ", retono='" + retono + '\'' +
                ", whcode='" + whcode + '\'' +
                ", orderno='" + orderno + '\'' +
                ", storecode='" + storecode + '\'' +
                ", expresscode='" + expresscode + '\'' +
                ", expressnumber='" + expressnumber + '\'' +
                ", mobile='" + mobile + '\'' +
                ", consigneeaddress='" + consigneeaddress + '\'' +
                ", consigneename='" + consigneename + '\'' +
                ", shopcode='" + shopcode + '\'' +
                ", shopname='" + shopname + '\'' +
                ", tradeid='" + tradeid + '\'' +
                ", receivedfee=" + receivedfee +
                '}';
    }
}
