package m2j.commons;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 395214819616063L;

	/**
	 * Singleton instance of this class, which doesn't consider local addresses
	 * as valid.
	 */
	private static final EmailValidator EMAIL_VALIDATOR = new EmailValidator(false, false);

	private static final EmailValidator EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD = null;

	private static final EmailValidator EMAIL_VALIDATOR_WITH_LOCAL = null;

	private static final EmailValidator EMAIL_VALIDATOR_WITH_TLD = null;
	private final boolean allowLocal;
	private final boolean allowTld;
	private static final String SPECIAL_CHARS = "\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]";
	    private static final String VALID_CHARS = "(\\\\.)|[^\\s" + SPECIAL_CHARS + "]";
	    private static final String QUOTED_USER = "(\"(\\\\\"|[^\"])*\")";
	
	private static final String WORD = "((" + VALID_CHARS + "|')+|" + QUOTED_USER + ")";
	
	private static final String EMAIL_REGEX = "^\\s*?(.+)@(.+?)\\s*$";
	private static final String USER_REGEX = "^\\s*" + WORD + "(\\." + WORD + ")*$";
	 private static final String IP_DOMAIN_REGEX = "^\\[(.*)\\]$";
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	 private static final Pattern IP_DOMAIN_PATTERN = Pattern.compile(IP_DOMAIN_REGEX);

	private static final int MAX_USERNAME_LEN = 0;

	private static final Pattern USER_PATTERN = null;

	/**
	 * 128 * Protected constructor for subclasses to use. 129 * 130 * @param
	 * allowLocal Should local addresses be considered valid? 131 * @param
	 * allowTld Should TLDs be allowed? 132
	 */
	protected EmailValidator(boolean allowLocal, boolean allowTld) {
		super();
		this.allowLocal = allowLocal;
		this.allowTld = allowTld;
	}

	public static EmailValidator getInstance() {
		return EMAIL_VALIDATOR;
	}
	
    /**
     * Protected constructor for subclasses to use.
     *
     * @param allowLocal Should local addresses be considered valid?
     */
    protected EmailValidator(boolean allowLocal) {
        super();
        this.allowLocal = allowLocal;
        this.allowTld = false;
    }

	/**
	 * 3 * Returns the Singleton instance of this validator, 4 * with local
	 * validation as required. 5 * 6 * @param allowLocal Should local addresses
	 * be considered valid? 7 * @param allowTld Should TLDs be allowed? 8
	 * * @return singleton instance of this validator 9
	 */
	public static EmailValidator getInstance(boolean allowLocal, boolean allowTld) {
		if (allowLocal) {
			if (allowTld) {
				return EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD;
			} else {
				return EMAIL_VALIDATOR_WITH_LOCAL;
			}
		} else {
			if (allowTld) {
				return EMAIL_VALIDATOR_WITH_TLD;
			} else {
				return EMAIL_VALIDATOR;
			}
		}
	}
	
	   /**
	151     * <p>Checks if a field has a valid e-mail address.</p>
	152     *
	153     * @param email The value validation is being performed on.  A <code>null</code>
	154     *              value is considered invalid.
	155     * @return true if the email address is valid.
	156     */
	public boolean isValid(String email) {
		if (email == null) {
			return false;
		}

		if (email.endsWith(".")) { // check this first - it's cheap!
			return false;
		}

		// Check the whole email address structure
		Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
		if (!emailMatcher.matches()) {
			return false;
		}

		if (!isValidUser(emailMatcher.group(1))) {
			return false;
		}

		if (!isValidDomain(emailMatcher.group(2))) {
			return false;
		}

		return true;
	}
	
    /**
184     * Returns true if the domain component of an email address is valid.
185     *
186     * @param domain being validated, may be in IDN format
187     * @return true if the email address's domain is valid.
188     */
    protected boolean isValidDomain(String domain) {
        // see if domain is an IP address in brackets
        Matcher ipDomainMatcher = IP_DOMAIN_PATTERN.matcher(domain);

        if (ipDomainMatcher.matches()) {
            InetAddressValidator inetAddressValidator =
                    InetAddressValidator.getInstance();
            return inetAddressValidator.isValid(ipDomainMatcher.group(1));
        }
        // Domain is symbolic name
        DomainValidator domainValidator =
                DomainValidator.getInstance(allowLocal);
        if (allowTld) {
            return domainValidator.isValid(domain) || (!domain.startsWith(".") && domainValidator.isValidTld(domain));
        } else {
            return domainValidator.isValid(domain);
        }
    }
    
    /**
209     * Returns true if the user component of an email address is valid.
210     *
211     * @param user being validated
212     * @return true if the user name is valid.
213     */
    protected boolean isValidUser(String user) {
        
        if (user == null || user.length() > MAX_USERNAME_LEN) {
            return false;
        }
        
        return USER_PATTERN.matcher(user).matches();
    }

}

