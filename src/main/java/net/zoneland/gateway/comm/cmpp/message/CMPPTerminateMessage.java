package net.zoneland.gateway.comm.cmpp.message;

import net.zoneland.gateway.comm.cmpp.CMPPConstant;
import net.zoneland.gateway.util.TypeConvert;

public class CMPPTerminateMessage extends CMPPMessage
{

    public CMPPTerminateMessage()
    {
        int len = 12;
        super.buf = new byte[len];
        TypeConvert.int2byte(len, super.buf, 0);
        TypeConvert.int2byte(2, super.buf, 4);
    }

    public CMPPTerminateMessage(byte buf[])
        throws IllegalArgumentException
    {
        super.buf = new byte[4];
        if(buf.length != 4)
        {
            throw new IllegalArgumentException(CMPPConstant.SMC_MESSAGE_ERROR);
        } else
        {
            System.arraycopy(buf, 0, super.buf, 0, 4);
            super.sequence_Id = TypeConvert.byte2int(super.buf, 0);
            return;
        }
    }

    public String toString()
    {
        String tmpStr = "CMPP_Terminate: ";
        tmpStr = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(tmpStr)))).append("Sequence_Id=").append(getSequenceId())));
        return tmpStr;
    }

    public int getCommandId()
    {
        return 2;
    }
}
