package cn.edu.buaa.crypto.chameleonhash.kr00.params;

import cn.edu.buaa.crypto.Utils;
import cn.edu.buaa.crypto.pairingkem.params.PairingKeyParameters;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.PairingParameters;

/**
 * Created by Weiran Liu on 2016/4/5.
 */
public class CHKR00PublicKeyParameters extends PairingKeyParameters {
    private final Element g;
    private final Element y;

    public CHKR00PublicKeyParameters(PairingParameters pairingParameters, Element g, Element y) {
        super(false, pairingParameters);
        this.g = g.getImmutable();
        this.y = y.getImmutable();
    }

    public Element getG() { return this.g.duplicate(); }

    public Element getY() { return this.y.duplicate(); }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof CHKR00PublicKeyParameters) {
            CHKR00PublicKeyParameters that = (CHKR00PublicKeyParameters)anObject;
            //Compare y
            if (!Utils.isEqualElement(this.y, that.getY())) {
                return false;
            }
            //Compare params
            return super.equals(anObject);
        }
        return false;
    }
}
