// Day 5 of Stream Training

/* Using XML serialization to create a XML document.
 * 
 * Anurag Bhandari
 * 01-10-2009
 */

using System;
using System.Collections.Generic;
using System.Text;
using System.Xml.Serialization;
using System.IO;

namespace XMLSerialization
{
    [XmlRoot(ElementName="Employee")]
    public class Employee
    {
        String empID;
        String empName;
        int empAge;
        String[] empSkills;

        [XmlAttribute(AttributeName="EmpID")]
        public String EmpID
        {
            get 
            {
                return empID;
            }
            set 
            {
                empID = value;
            }
        }

        [XmlElement(ElementName = "Name")]
        public String Name
        {
            get
            {
                return empName;
            }
            set
            {
                empName = value;
            }
        }

        [XmlElement(ElementName = "Age")]
        public int Age
        {
            get
            {
                return empAge;
            }
            set
            {
                empAge = value;
            }
        }

        [XmlElement(ElementName = "Skills")]
        public String[] Skills
        {
            get
            {
                return empSkills;
            }
            set
            {
                empSkills = value;
            }
        }

        static void Main(string[] args)
        {
            String[] skills = {"C#", "SQL Server 2005"};
            Employee emp_1 = new Employee();
            emp_1.EmpID = "EMP1001";
            emp_1.Name = "George";
            emp_1.Age = 26;
            emp_1.Skills = skills;

            Employee emp_2 = new Employee();
            emp_2.EmpID = "EMP1001";
            emp_2.Name = "George";
            emp_2.Age = 26;
            emp_2.Skills = skills;

            StreamWriter newStream = File.CreateText(@"C:\SerializeSample.xml");
            XmlSerializer xmlSerialize = new XmlSerializer(typeof(Employee));
            xmlSerialize.Serialize(newStream, emp_1);
            //xmlSerialize.Serialize(newStream, emp_2);
            newStream.Close();
        }
    }
}
