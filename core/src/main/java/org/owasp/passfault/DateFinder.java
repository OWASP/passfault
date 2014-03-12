/* ©Copyright 2011 Cameron Morris
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.owasp.passfault;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * No, this is not a dating service.  It is a PatternFinder for numbers in date format
 * like 12-25-'76,  MMDDYY DDMMYY, etc
 *
 * is a date really worth finding?
 * 6 random numbers: 482934 has 10 chars possible in the pattern = 10^6 = 1,000,000
 * date number: 122576 has 12 chars * 31 chars * 100 chars = 37,200
 * Maybe, maybe not, but it isn't hard to code, and doesn't take much processing, so why not.
 *
 * @author cam
 */
public class DateFinder implements PatternFinder {

  public final static String DATE_PATTERN = "DATE_PATTERN";

  Pattern dateRegex = Pattern.compile(
      "(\\d\\d)?\\d\\d([- /.])?(0[1-9]|1[012])([- /.])?(0[1-9]|[12][0-9]|3[01])|"+ // year/month/day
      "(\\d\\d)?\\d\\d([- /.])?(0[1-9]|[12][0-9]|3[01])([- /.])?(0[1-9]|1[012])|"+ // year/day/month
      "(0[1-9]|1[012])([- /.])?(0[1-9]|[12][0-9]|3[01])([- /.])?(\\d\\d)?\\d\\d|"+ // month/day/year
      "(0[1-9]|[12][0-9]|3[01])([- /.])?(0[1-9]|1[012])([- /.])?(\\d\\d)?\\d\\d|");// month/day/year
  double dateSize = 12 * 31 * 2500; // days * chars * years (future proof by 500 years

  @Override
  public void analyze(PasswordResults pass) throws Exception {
    CharSequence chars = pass.getCharSequence();
    Matcher matcher = dateRegex.matcher(chars);
    boolean found = false;
    do {
      found = matcher.find();
      if(found){
        int start = matcher.start();
        int end = matcher.end();
        int length = end-start;
        CharSequence matchString = chars.subSequence(start, end);

        pass.foundPattern(new PasswordPattern(
            start, length, matchString, dateSize, "Date Format", DATE_PATTERN, null));
      }
    } while (found);
  }
}
