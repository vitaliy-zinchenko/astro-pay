package zinjvi.model;

import javax.persistence.*;

/**
 * Created by Vitaliy on 12/4/2015.
 */
@Entity
@Table(name = "ap_merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long merchantId;

    private String account;

    private String domainName;

    private String authorizationType;

    private String currency;

    private String privateKey;

    private Boolean active;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(String authorizationType) {
        this.authorizationType = authorizationType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
