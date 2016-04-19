package org.zinn.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZipCode
{
    private String m_zipCode = "";
    private String m_town = "";
    private String m_type = "";
    private String m_state = "";
    private String m_county = "";

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZipCode zipCode = (ZipCode) o;

        return m_zipCode.equals(zipCode.m_zipCode);

    }

    @Override
    public int hashCode()
    {
        return m_zipCode.hashCode();
    }

    @Override
    public String toString()
    {
        return "ZipCode " + m_zipCode;
    }

    public String getZipCode()
    {
        return m_zipCode;
    }

    public void setZipCode(String zipCode)
    {
        m_zipCode = zipCode;
    }

    public String getTown()
    {
        return m_town;
    }

    public void setTown(String town)
    {
        m_town = town;
    }

    public String getType()
    {
        return m_type;
    }

    public void setType(String type)
    {
        m_type = type;
    }

    public String getState()
    {
        return m_state;
    }

    public void setState(String state)
    {
        m_state = state;
    }

    public String getCounty()
    {
        return m_county;
    }

    public void setCounty(String county)
    {
        m_county = county;
    }
}
