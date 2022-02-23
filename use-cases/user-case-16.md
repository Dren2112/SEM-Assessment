<h1>User Case #16 - Show top [n] populated capital cities where [n] is provided by the user</h1>
<hr>
<b>Goal in Context</b>: <i>As an organisation, we want to find the top populated capital cities in the world, where the amount of cities shown is dictated by user input, n, so that a report acn be generated. </i>

<b>Scope</b>: Organisation

<b>Level</b>: Primary Task

<b>Preconditions</b>: The World database contains all the data necessary for generating the report based on population in capital cities.

<b>Success Condition</b>: User input is read, data is sorted and listed correctly, a report is made.

<b>Failed Condition</b>: User intut is not read, data is not sorted or listed correctly, report cannot be made.

<b>Primary Actor</b>: User / any agent of the organisation

<b>Trigger</b>: A report  is required

<hr>

<b>Main Success Scenario</b>
1. User enters a number, n, to display the number of top populated capital cities
2. Capital cities are sorted by largest population to smallest, displaying only n results
3. A report is made


<hr>

<b>Extensions</b>
1. *User needs the top <i>n</i> populated capital cities in a <i>continent</i> where <i>n</i> is provided by the user.
2. *User needs the top <i>n</i> populated capital cities in a <i>region</i> where <i>n</i> is provided by the user.

<hr>

<b>Sub-variations</b>
1. All the capital cities in a <i>continent</i> are sorted by largest population to smallest, displaying only <i>n</i> results
2. All the capital cities in a <i>region</i> are sorted by largest population to smallest, displaying only <i>n</i> results

<hr>

<b>Schedule</b>

<p>Due Date: <i>Release 1.0</i></p>
