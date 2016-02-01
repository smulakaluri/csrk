
package com.cisco.cstg.autotools.domain.appdb;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TABLE_TEST_SUITE_TEST")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TestSuiteTest extends IdentifiableEntity {

    /**
	 * 
	*/
	private static final long serialVersionUID = 8920600437411386305L;

//	private  Long testSuiteId;
//
//    private Long testId;
    
    private TestSuite testSuite;

    private Test test;

    @ManyToOne(targetEntity=TestSuite.class) 
    @JoinColumn(name = "TEST_SUITE_ID", referencedColumnName="id")
	public TestSuite getTestSuite() {
		return testSuite;
	}

	public void setTestSuite(TestSuite testSuite) {
		this.testSuite = testSuite;
	}

	@ManyToOne(targetEntity=Test.class) 
    @JoinColumn(name = "TEST_ID", referencedColumnName="id")
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

//	@Column(name="TEST_SUITE_ID")
//	public Long getTestSuiteId() {
//		return testSuiteId;
//	}
//
//	public void setTestSuiteId(Long testSuiteId) {
//		this.testSuiteId = testSuiteId;
//	}
//
//	@Column(name="TEST_ID")
//	public Long getTestId() {
//		return testId;
//	}
//
//	public void setTestId(Long testId) {
//		this.testId = testId;
//	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (this.getId() == null) {
            return false;
        } else if (o instanceof TestSuiteTest) {
            TestSuiteTest that = (TestSuiteTest) o;
            return this.getId().equals(that.getId());
        } else {
            return false;
        }
    }

	@Override
    public int hashCode() {
        return this.getId() == null ? System.identityHashCode(this) : 17 * this.getId()
                .hashCode();
    }

    @Transient
    public String getName() {
        return this.getId() + " " + this.getId();
    }

    @Override
    public String toString() {
        return this.getName();
    }
   
}