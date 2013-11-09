
    

  

<!DOCTYPE html>
<html>
  <head>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <script type="text/javascript">var NREUMQ=[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
        <title>src/main/javascript/org/owasp/esapi/jquery/encoder.js at master from chrisisbeef/jquery-encoder - GitHub</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />

    
    

    <meta content="authenticity_token" name="csrf-param" />
<meta content="47be2a4761578e333c58ec2b79b0a7040f98c837" name="csrf-token" />

    <link href="https://a248.e.akamai.net/assets.github.com/068419c425628d587ea5ca8ca8e98052f6f6b070/stylesheets/bundle_github.css" media="screen" rel="stylesheet" type="text/css" />
    

    <script type="text/javascript">
      if (typeof console == "undefined" || typeof console.log == "undefined")
        console = { log: function() {} }
    </script>
    <script type="text/javascript" charset="utf-8">
      var GitHub = {
        assetHost: 'https://a248.e.akamai.net/assets.github.com'
      }
      var github_user = null
      
    </script>
    <script src="https://a248.e.akamai.net/assets.github.com/javascripts/jquery/jquery-1.6.1.min.js" type="text/javascript"></script>
    <script src="https://a248.e.akamai.net/assets.github.com/ad23f261a1b93dfd00e6954a67d9148313a96444/javascripts/bundle_github.js" type="text/javascript"></script>


    
    <script type="text/javascript" charset="utf-8">
      GitHub.spy({
        repo: "chrisisbeef/jquery-encoder"
      })
    </script>

    
  <link rel='permalink' href='/chrisisbeef/jquery-encoder/blob/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main/javascript/org/owasp/esapi/jquery/encoder.js'>

  <link href="https://github.com/chrisisbeef/jquery-encoder/commits/master.atom" rel="alternate" title="Recent Commits to jquery-encoder:master" type="application/atom+xml" />

    

    <meta name="description" content="jquery-encoder - Contextual Output Encoding for jQuery" />
    <script type="text/javascript">
      GitHub.nameWithOwner = GitHub.nameWithOwner || "chrisisbeef/jquery-encoder";
      GitHub.currentRef = 'master';
      GitHub.commitSHA = "c1512c5ad0f6f5c15331fb2b3a3628579c8ec556";
      GitHub.currentPath = 'src/main/javascript/org/owasp/esapi/jquery/encoder.js';
      GitHub.masterBranch = "master";

      
    </script>
  

        <script type="text/javascript">
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-3769691-2']);
      _gaq.push(['_setDomainName', 'none']);
      _gaq.push(['_trackPageview']);
      _gaq.push(['_trackPageLoadTime']);
      (function() {
        var ga = document.createElement('script');
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        ga.setAttribute('async', 'true');
        document.documentElement.firstChild.appendChild(ga);
      })();
    </script>

    
  </head>

  

  <body class="logged_out page-blob windows env-production">
    

    

    

    <div class="subnavd" id="main">
      <div id="header" class="true">
          <a class="logo boring" href="https://github.com">
            
            <img alt="github" class="default" height="45" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov6.png" />
            <!--[if (gt IE 8)|!(IE)]><!-->
            <img alt="github" class="hover" height="45" src="https://a248.e.akamai.net/assets.github.com/images/modules/header/logov6-hover.png" />
            <!--<![endif]-->
          </a>

        
        <div class="topsearch">
  
    <!--
      make sure to use fully qualified URLs here since this nav
      is used on error pages on other domains
    -->
    <ul class="nav logged_out">
      
      <li class="pricing"><a href="https://github.com/plans">Pricing and Signup</a></li>
      
      <li class="explore"><a href="https://github.com/explore">Explore GitHub</a></li>
      <li class="features"><a href="https://github.com/features">Features</a></li>
      
      <li class="blog"><a href="https://github.com/blog">Blog</a></li>
      
      <li class="login"><a href="https://github.com/login">Login</a></li>
    </ul>
  
</div>

      </div>

      
      
        
    <div class="site">
      <div class="pagehead repohead vis-public    instapaper_ignore readability-menu">

      
      <div id="entice">
        <div class="explanation">
          <h2><strong>chrisisbeef</strong> is using GitHub to share code with you!</h2>
        <p>
          GitHub is more than just a place to share code. It's a place to keep tabs on your favorite developers and projects, easily contribute fixes and new features, and visualize what's going on inside your codebase!
        </p>
        </div>
        <div class="signup">
          <a href="/signup/free?green&amp;referral_code=entice-banner" id="entice-signup-button">Sign Up Now</a>
          <p id="oss-caption">Free for open source</p>
        </div>
      </div>
      
    

      <div class="title-actions-bar">
        <h1>
          <a href="/chrisisbeef">chrisisbeef</a> / <strong><a href="/chrisisbeef/jquery-encoder">jquery-encoder</a></strong>
          
          
        </h1>

        
    <ul class="actions">
      

      
        <li class="for-owner" style="display:none"><a href="/chrisisbeef/jquery-encoder/admin" class="minibutton btn-admin "><span><span class="icon"></span>Admin</span></a></li>
        <li>
          <a href="/chrisisbeef/jquery-encoder/toggle_watch" class="minibutton btn-watch " id="watch_button" onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '47be2a4761578e333c58ec2b79b0a7040f98c837'); f.appendChild(s);f.submit();return false;" style="display:none"><span><span class="icon"></span>Watch</span></a>
          <a href="/chrisisbeef/jquery-encoder/toggle_watch" class="minibutton btn-watch " id="unwatch_button" onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '47be2a4761578e333c58ec2b79b0a7040f98c837'); f.appendChild(s);f.submit();return false;" style="display:none"><span><span class="icon"></span>Unwatch</span></a>
        </li>
        
          
            <li class="for-notforked" style="display:none"><a href="/chrisisbeef/jquery-encoder/fork" class="minibutton btn-fork " id="fork_button" onclick="var f = document.createElement('form'); f.style.display = 'none'; this.parentNode.appendChild(f); f.method = 'POST'; f.action = this.href;var s = document.createElement('input'); s.setAttribute('type', 'hidden'); s.setAttribute('name', 'authenticity_token'); s.setAttribute('value', '47be2a4761578e333c58ec2b79b0a7040f98c837'); f.appendChild(s);f.submit();return false;"><span><span class="icon"></span>Fork</span></a></li>
            <li class="for-hasfork" style="display:none"><a href="#" class="minibutton btn-fork " id="your_fork_button"><span><span class="icon"></span>Your Fork</span></a></li>
          

          
        
      
      
      <li class="repostats">
        <ul class="repo-stats">
          <li class="watchers"><a href="/chrisisbeef/jquery-encoder/watchers" title="Watchers" class="tooltipped downwards">9</a></li>
          <li class="forks"><a href="/chrisisbeef/jquery-encoder/network" title="Forks" class="tooltipped downwards">1</a></li>
        </ul>
      </li>
    </ul>

      </div>

        
  <ul class="tabs">
    <li><a href="/chrisisbeef/jquery-encoder" class="selected" highlight="repo_source">Source</a></li>
    <li><a href="/chrisisbeef/jquery-encoder/commits/master" highlight="repo_commits">Commits</a></li>
    <li><a href="/chrisisbeef/jquery-encoder/network" highlight="repo_network">Network</a></li>
    <li><a href="/chrisisbeef/jquery-encoder/pulls" highlight="repo_pulls">Pull Requests (0)</a></li>

    

    
      
      <li><a href="/chrisisbeef/jquery-encoder/issues" highlight="issues">Issues (2)</a></li>
    

            
    <li><a href="/chrisisbeef/jquery-encoder/graphs" highlight="repo_graphs">Graphs</a></li>

    

    <li class="contextswitch nochoices">
      <span class="toggle leftwards" >
        <em>Branch:</em>
        <code>master</code>
      </span>
    </li>
  </ul>

  <div style="display:none" id="pl-description"><p><em class="placeholder">click here to add a description</em></p></div>
  <div style="display:none" id="pl-homepage"><p><em class="placeholder">click here to add a homepage</em></p></div>

  <div class="subnav-bar">
  
  <ul>
    <li>
      <a href="/chrisisbeef/jquery-encoder/branches" class="dropdown">Switch Branches (1)</a>
      <ul>
        
          
            <li><strong>master &#x2713;</strong></li>
            
      </ul>
    </li>
    <li>
      <a href="#" class="dropdown defunct">Switch Tags (0)</a>
      
    </li>
    <li>
    
    <a href="/chrisisbeef/jquery-encoder/branches" class="manage">Branch List</a>
    
    </li>
  </ul>
</div>

  
  
  
  
  
  



        
    <div id="repo_details" class="metabox clearfix">
      <div id="repo_details_loader" class="metabox-loader" style="display:none">Sending Request&hellip;</div>

      
        <a href="/chrisisbeef/jquery-encoder/downloads" class="download-source" id="download_button" title="Download source, tagged packages and binaries."><span class="icon"></span>Downloads</a>
      

      <div id="repository_desc_wrapper">
      <div id="repository_description" rel="repository_description_edit">
        
          <p>Contextual Output Encoding for jQuery
            <span id="read_more" style="display:none">&mdash; <a href="#readme">Read more</a></span>
          </p>
        
      </div>

      <div id="repository_description_edit" style="display:none;" class="inline-edit">
        <form action="/chrisisbeef/jquery-encoder/admin/update" method="post"><div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="47be2a4761578e333c58ec2b79b0a7040f98c837" /></div>
          <input type="hidden" name="field" value="repository_description">
          <input type="text" class="textfield" name="value" value="Contextual Output Encoding for jQuery">
          <div class="form-actions">
            <button class="minibutton"><span>Save</span></button> &nbsp; <a href="#" class="cancel">Cancel</a>
          </div>
        </form>
      </div>

      
      <div class="repository-homepage" id="repository_homepage" rel="repository_homepage_edit">
        <p><a href="http://" rel="nofollow"></a></p>
      </div>

      <div id="repository_homepage_edit" style="display:none;" class="inline-edit">
        <form action="/chrisisbeef/jquery-encoder/admin/update" method="post"><div style="margin:0;padding:0"><input name="authenticity_token" type="hidden" value="47be2a4761578e333c58ec2b79b0a7040f98c837" /></div>
          <input type="hidden" name="field" value="repository_homepage">
          <input type="text" class="textfield" name="value" value="">
          <div class="form-actions">
            <button class="minibutton"><span>Save</span></button> &nbsp; <a href="#" class="cancel">Cancel</a>
          </div>
        </form>
      </div>
      </div>
      <div class="rule "></div>
      <div class="url-box">
  

  <ul class="clone-urls">
    
      
      <li class="http_clone_url"><a href="https://github.com/chrisisbeef/jquery-encoder.git" data-permissions="Read-Only">HTTP</a></li>
      <li class="public_clone_url"><a href="git://github.com/chrisisbeef/jquery-encoder.git" data-permissions="Read-Only">Git Read-Only</a></li>
    
    
  </ul>
  <input type="text" spellcheck="false" class="url-field" />
        <span style="display:none" id="clippy_3147" class="url-box-clippy"></span>
      <span id="clippy_tooltip_clippy_3147" class="clippy-tooltip tooltipped" title="copy to clipboard">
      <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
              width="14"
              height="14"
              class="clippy"
              id="clippy" >
      <param name="movie" value="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"/>
      <param name="allowScriptAccess" value="always" />
      <param name="quality" value="high" />
      <param name="scale" value="noscale" />
      <param NAME="FlashVars" value="id=clippy_3147&amp;copied=&amp;copyto=">
      <param name="bgcolor" value="#FFFFFF">
      <param name="wmode" value="opaque">
      <embed src="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"
             width="14"
             height="14"
             name="clippy"
             quality="high"
             allowScriptAccess="always"
             type="application/x-shockwave-flash"
             pluginspage="http://www.macromedia.com/go/getflashplayer"
             FlashVars="id=clippy_3147&amp;copied=&amp;copyto="
             bgcolor="#FFFFFF"
             wmode="opaque"
      />
      </object>
      </span>

  <p class="url-description"><strong>Read+Write</strong> access</p>
</div>

    </div>

    <div class="frame frame-center tree-finder" style="display:none">
      <div class="breadcrumb">
        <b><a href="/chrisisbeef/jquery-encoder">jquery-encoder</a></b> /
        <input class="tree-finder-input" type="text" name="query" autocomplete="off" spellcheck="false">
      </div>

      
        <div class="octotip">
          <p>
            <a href="/chrisisbeef/jquery-encoder/dismiss-tree-finder-help" class="dismiss js-dismiss-tree-list-help" title="Hide this notice forever">Dismiss</a>
            <strong>Octotip:</strong> You've activated the <em>file finder</em> by pressing <span class="kbd">t</span>
            Start typing to filter the file list. Use <span class="kbd badmono">↑</span> and <span class="kbd badmono">↓</span> to navigate,
            <span class="kbd">enter</span> to view files.
          </p>
        </div>
      

      <table class="tree-browser" cellpadding="0" cellspacing="0">
        <tr class="js-header"><th>&nbsp;</th><th>name</th></tr>
        <tr class="js-no-results no-results" style="display: none">
          <th colspan="2">No matching files</th>
        </tr>
        <tbody class="js-results-list">
        </tbody>
      </table>
    </div>

    <div id="jump-to-line" style="display:none">
      <h2>Jump to Line</h2>
      <form>
        <input class="textfield" type="text">
        <div class="full-button">
          <button type="submit" class="classy">
            <span>Go</span>
          </button>
        </div>
      </form>
    </div>


        

      </div><!-- /.pagehead -->

      

  







<script type="text/javascript">
  GitHub.downloadRepo = '/chrisisbeef/jquery-encoder/archives/master'
  GitHub.revType = "master"

  GitHub.repoName = "jquery-encoder"
  GitHub.controllerName = "blob"
  GitHub.actionName     = "show"
  GitHub.currentAction  = "blob#show"

  
    GitHub.loggedIn = false
  

  
</script>







  <div id="commit">
    <div class="group">
        
  <div class="envelope commit">
    <div class="human">
      
        <div class="message"><pre><a href="/chrisisbeef/jquery-encoder/commit/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556">added property aware contextual encoding</a> </pre></div>
      

      <div class="actor">
        <div class="gravatar">
          
          <img src="https://secure.gravatar.com/avatar/78eea89a896456024eaa5be193931032?s=140&d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-140.png" alt="" width="30" height="30"  />
        </div>
        <div class="name">Chris Schmidt <span>(author)</span></div>
        <div class="date">
          <time class="js-relative-date" datetime="2011-03-07T07:31:03-08:00" title="2011-03-07 07:31:03">March 07, 2011</time>
        </div>
      </div>

      

    </div>
    <div class="machine">
      <span>c</span>ommit&nbsp;&nbsp;<a href="/chrisisbeef/jquery-encoder/commit/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556" class="js-commit-link" data-key="c">c1512c5ad0f6f5c15331</a><br />
      <span>t</span>ree&nbsp;&nbsp;&nbsp;&nbsp;<a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556" class="js-tree-link" data-key="t">fc970c28f0f51412983e</a><br />
      
        <span>p</span>arent&nbsp;
        
        <a href="/chrisisbeef/jquery-encoder/tree/8c91a6d7808eadcc991664a71057dd1a2d81a8cc" class="js-parent-link" data-key="p">8c91a6d7808eadcc9916</a>
      

    </div>
  </div>

    </div>
  </div>



  <div id="slider">

  

    <div class="breadcrumb" data-path="src/main/javascript/org/owasp/esapi/jquery/encoder.js/">
      <b><a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556">jquery-encoder</a></b> / <a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src">src</a> / <a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main">main</a> / <a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main/javascript">javascript</a> / <a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main/javascript/org">org</a> / <a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main/javascript/org/owasp">owasp</a> / <a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main/javascript/org/owasp/esapi">esapi</a> / <a href="/chrisisbeef/jquery-encoder/tree/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main/javascript/org/owasp/esapi/jquery">jquery</a> / encoder.js       <span style="display:none" id="clippy_463" class="clippy">src/main/javascript/org/owasp/esapi/jquery/encoder.js</span>
      
      <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
              width="110"
              height="14"
              class="clippy"
              id="clippy" >
      <param name="movie" value="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"/>
      <param name="allowScriptAccess" value="always" />
      <param name="quality" value="high" />
      <param name="scale" value="noscale" />
      <param NAME="FlashVars" value="id=clippy_463&amp;copied=copied!&amp;copyto=copy to clipboard">
      <param name="bgcolor" value="#FFFFFF">
      <param name="wmode" value="opaque">
      <embed src="https://a248.e.akamai.net/assets.github.com/flash/clippy.swf?v5"
             width="110"
             height="14"
             name="clippy"
             quality="high"
             allowScriptAccess="always"
             type="application/x-shockwave-flash"
             pluginspage="http://www.macromedia.com/go/getflashplayer"
             FlashVars="id=clippy_463&amp;copied=copied!&amp;copyto=copy to clipboard"
             bgcolor="#FFFFFF"
             wmode="opaque"
      />
      </object>
      

    </div>

    <div class="frames">
      <div class="frame frame-center" data-path="src/main/javascript/org/owasp/esapi/jquery/encoder.js/" data-permalink-url="/chrisisbeef/jquery-encoder/blob/c1512c5ad0f6f5c15331fb2b3a3628579c8ec556/src/main/javascript/org/owasp/esapi/jquery/encoder.js">
        
          <ul class="big-actions">
            
            <li><a class="file-edit-link minibutton" href="/chrisisbeef/jquery-encoder/edit/__current_ref__/src/main/javascript/org/owasp/esapi/jquery/encoder.js"><span>Edit this file</span></a></li>
          </ul>
        

        <div id="files">
          <div class="file">
            <div class="meta">
              <div class="info">
                <span class="icon"><img alt="Txt" height="16" src="https://a248.e.akamai.net/assets.github.com/images/icons/txt.png" width="16" /></span>
                <span class="mode" title="File Mode">100755</span>
                
                  <span>1428 lines (1306 sloc)</span>
                
                <span>53.96 kb</span>
              </div>
              <ul class="actions">
                <li><a href="/chrisisbeef/jquery-encoder/raw/master/src/main/javascript/org/owasp/esapi/jquery/encoder.js" id="raw-url">raw</a></li>
                
                  <li><a href="/chrisisbeef/jquery-encoder/blame/master/src/main/javascript/org/owasp/esapi/jquery/encoder.js">blame</a></li>
                
                <li><a href="/chrisisbeef/jquery-encoder/commits/master/src/main/javascript/org/owasp/esapi/jquery/encoder.js">history</a></li>
              </ul>
            </div>
            
  <div class="data type-javascript">
    
      <table cellpadding="0" cellspacing="0" class="lines">
        <tr>
          <td>
            <pre class="line_numbers"><span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>
<span id="L198" rel="#L198">198</span>
<span id="L199" rel="#L199">199</span>
<span id="L200" rel="#L200">200</span>
<span id="L201" rel="#L201">201</span>
<span id="L202" rel="#L202">202</span>
<span id="L203" rel="#L203">203</span>
<span id="L204" rel="#L204">204</span>
<span id="L205" rel="#L205">205</span>
<span id="L206" rel="#L206">206</span>
<span id="L207" rel="#L207">207</span>
<span id="L208" rel="#L208">208</span>
<span id="L209" rel="#L209">209</span>
<span id="L210" rel="#L210">210</span>
<span id="L211" rel="#L211">211</span>
<span id="L212" rel="#L212">212</span>
<span id="L213" rel="#L213">213</span>
<span id="L214" rel="#L214">214</span>
<span id="L215" rel="#L215">215</span>
<span id="L216" rel="#L216">216</span>
<span id="L217" rel="#L217">217</span>
<span id="L218" rel="#L218">218</span>
<span id="L219" rel="#L219">219</span>
<span id="L220" rel="#L220">220</span>
<span id="L221" rel="#L221">221</span>
<span id="L222" rel="#L222">222</span>
<span id="L223" rel="#L223">223</span>
<span id="L224" rel="#L224">224</span>
<span id="L225" rel="#L225">225</span>
<span id="L226" rel="#L226">226</span>
<span id="L227" rel="#L227">227</span>
<span id="L228" rel="#L228">228</span>
<span id="L229" rel="#L229">229</span>
<span id="L230" rel="#L230">230</span>
<span id="L231" rel="#L231">231</span>
<span id="L232" rel="#L232">232</span>
<span id="L233" rel="#L233">233</span>
<span id="L234" rel="#L234">234</span>
<span id="L235" rel="#L235">235</span>
<span id="L236" rel="#L236">236</span>
<span id="L237" rel="#L237">237</span>
<span id="L238" rel="#L238">238</span>
<span id="L239" rel="#L239">239</span>
<span id="L240" rel="#L240">240</span>
<span id="L241" rel="#L241">241</span>
<span id="L242" rel="#L242">242</span>
<span id="L243" rel="#L243">243</span>
<span id="L244" rel="#L244">244</span>
<span id="L245" rel="#L245">245</span>
<span id="L246" rel="#L246">246</span>
<span id="L247" rel="#L247">247</span>
<span id="L248" rel="#L248">248</span>
<span id="L249" rel="#L249">249</span>
<span id="L250" rel="#L250">250</span>
<span id="L251" rel="#L251">251</span>
<span id="L252" rel="#L252">252</span>
<span id="L253" rel="#L253">253</span>
<span id="L254" rel="#L254">254</span>
<span id="L255" rel="#L255">255</span>
<span id="L256" rel="#L256">256</span>
<span id="L257" rel="#L257">257</span>
<span id="L258" rel="#L258">258</span>
<span id="L259" rel="#L259">259</span>
<span id="L260" rel="#L260">260</span>
<span id="L261" rel="#L261">261</span>
<span id="L262" rel="#L262">262</span>
<span id="L263" rel="#L263">263</span>
<span id="L264" rel="#L264">264</span>
<span id="L265" rel="#L265">265</span>
<span id="L266" rel="#L266">266</span>
<span id="L267" rel="#L267">267</span>
<span id="L268" rel="#L268">268</span>
<span id="L269" rel="#L269">269</span>
<span id="L270" rel="#L270">270</span>
<span id="L271" rel="#L271">271</span>
<span id="L272" rel="#L272">272</span>
<span id="L273" rel="#L273">273</span>
<span id="L274" rel="#L274">274</span>
<span id="L275" rel="#L275">275</span>
<span id="L276" rel="#L276">276</span>
<span id="L277" rel="#L277">277</span>
<span id="L278" rel="#L278">278</span>
<span id="L279" rel="#L279">279</span>
<span id="L280" rel="#L280">280</span>
<span id="L281" rel="#L281">281</span>
<span id="L282" rel="#L282">282</span>
<span id="L283" rel="#L283">283</span>
<span id="L284" rel="#L284">284</span>
<span id="L285" rel="#L285">285</span>
<span id="L286" rel="#L286">286</span>
<span id="L287" rel="#L287">287</span>
<span id="L288" rel="#L288">288</span>
<span id="L289" rel="#L289">289</span>
<span id="L290" rel="#L290">290</span>
<span id="L291" rel="#L291">291</span>
<span id="L292" rel="#L292">292</span>
<span id="L293" rel="#L293">293</span>
<span id="L294" rel="#L294">294</span>
<span id="L295" rel="#L295">295</span>
<span id="L296" rel="#L296">296</span>
<span id="L297" rel="#L297">297</span>
<span id="L298" rel="#L298">298</span>
<span id="L299" rel="#L299">299</span>
<span id="L300" rel="#L300">300</span>
<span id="L301" rel="#L301">301</span>
<span id="L302" rel="#L302">302</span>
<span id="L303" rel="#L303">303</span>
<span id="L304" rel="#L304">304</span>
<span id="L305" rel="#L305">305</span>
<span id="L306" rel="#L306">306</span>
<span id="L307" rel="#L307">307</span>
<span id="L308" rel="#L308">308</span>
<span id="L309" rel="#L309">309</span>
<span id="L310" rel="#L310">310</span>
<span id="L311" rel="#L311">311</span>
<span id="L312" rel="#L312">312</span>
<span id="L313" rel="#L313">313</span>
<span id="L314" rel="#L314">314</span>
<span id="L315" rel="#L315">315</span>
<span id="L316" rel="#L316">316</span>
<span id="L317" rel="#L317">317</span>
<span id="L318" rel="#L318">318</span>
<span id="L319" rel="#L319">319</span>
<span id="L320" rel="#L320">320</span>
<span id="L321" rel="#L321">321</span>
<span id="L322" rel="#L322">322</span>
<span id="L323" rel="#L323">323</span>
<span id="L324" rel="#L324">324</span>
<span id="L325" rel="#L325">325</span>
<span id="L326" rel="#L326">326</span>
<span id="L327" rel="#L327">327</span>
<span id="L328" rel="#L328">328</span>
<span id="L329" rel="#L329">329</span>
<span id="L330" rel="#L330">330</span>
<span id="L331" rel="#L331">331</span>
<span id="L332" rel="#L332">332</span>
<span id="L333" rel="#L333">333</span>
<span id="L334" rel="#L334">334</span>
<span id="L335" rel="#L335">335</span>
<span id="L336" rel="#L336">336</span>
<span id="L337" rel="#L337">337</span>
<span id="L338" rel="#L338">338</span>
<span id="L339" rel="#L339">339</span>
<span id="L340" rel="#L340">340</span>
<span id="L341" rel="#L341">341</span>
<span id="L342" rel="#L342">342</span>
<span id="L343" rel="#L343">343</span>
<span id="L344" rel="#L344">344</span>
<span id="L345" rel="#L345">345</span>
<span id="L346" rel="#L346">346</span>
<span id="L347" rel="#L347">347</span>
<span id="L348" rel="#L348">348</span>
<span id="L349" rel="#L349">349</span>
<span id="L350" rel="#L350">350</span>
<span id="L351" rel="#L351">351</span>
<span id="L352" rel="#L352">352</span>
<span id="L353" rel="#L353">353</span>
<span id="L354" rel="#L354">354</span>
<span id="L355" rel="#L355">355</span>
<span id="L356" rel="#L356">356</span>
<span id="L357" rel="#L357">357</span>
<span id="L358" rel="#L358">358</span>
<span id="L359" rel="#L359">359</span>
<span id="L360" rel="#L360">360</span>
<span id="L361" rel="#L361">361</span>
<span id="L362" rel="#L362">362</span>
<span id="L363" rel="#L363">363</span>
<span id="L364" rel="#L364">364</span>
<span id="L365" rel="#L365">365</span>
<span id="L366" rel="#L366">366</span>
<span id="L367" rel="#L367">367</span>
<span id="L368" rel="#L368">368</span>
<span id="L369" rel="#L369">369</span>
<span id="L370" rel="#L370">370</span>
<span id="L371" rel="#L371">371</span>
<span id="L372" rel="#L372">372</span>
<span id="L373" rel="#L373">373</span>
<span id="L374" rel="#L374">374</span>
<span id="L375" rel="#L375">375</span>
<span id="L376" rel="#L376">376</span>
<span id="L377" rel="#L377">377</span>
<span id="L378" rel="#L378">378</span>
<span id="L379" rel="#L379">379</span>
<span id="L380" rel="#L380">380</span>
<span id="L381" rel="#L381">381</span>
<span id="L382" rel="#L382">382</span>
<span id="L383" rel="#L383">383</span>
<span id="L384" rel="#L384">384</span>
<span id="L385" rel="#L385">385</span>
<span id="L386" rel="#L386">386</span>
<span id="L387" rel="#L387">387</span>
<span id="L388" rel="#L388">388</span>
<span id="L389" rel="#L389">389</span>
<span id="L390" rel="#L390">390</span>
<span id="L391" rel="#L391">391</span>
<span id="L392" rel="#L392">392</span>
<span id="L393" rel="#L393">393</span>
<span id="L394" rel="#L394">394</span>
<span id="L395" rel="#L395">395</span>
<span id="L396" rel="#L396">396</span>
<span id="L397" rel="#L397">397</span>
<span id="L398" rel="#L398">398</span>
<span id="L399" rel="#L399">399</span>
<span id="L400" rel="#L400">400</span>
<span id="L401" rel="#L401">401</span>
<span id="L402" rel="#L402">402</span>
<span id="L403" rel="#L403">403</span>
<span id="L404" rel="#L404">404</span>
<span id="L405" rel="#L405">405</span>
<span id="L406" rel="#L406">406</span>
<span id="L407" rel="#L407">407</span>
<span id="L408" rel="#L408">408</span>
<span id="L409" rel="#L409">409</span>
<span id="L410" rel="#L410">410</span>
<span id="L411" rel="#L411">411</span>
<span id="L412" rel="#L412">412</span>
<span id="L413" rel="#L413">413</span>
<span id="L414" rel="#L414">414</span>
<span id="L415" rel="#L415">415</span>
<span id="L416" rel="#L416">416</span>
<span id="L417" rel="#L417">417</span>
<span id="L418" rel="#L418">418</span>
<span id="L419" rel="#L419">419</span>
<span id="L420" rel="#L420">420</span>
<span id="L421" rel="#L421">421</span>
<span id="L422" rel="#L422">422</span>
<span id="L423" rel="#L423">423</span>
<span id="L424" rel="#L424">424</span>
<span id="L425" rel="#L425">425</span>
<span id="L426" rel="#L426">426</span>
<span id="L427" rel="#L427">427</span>
<span id="L428" rel="#L428">428</span>
<span id="L429" rel="#L429">429</span>
<span id="L430" rel="#L430">430</span>
<span id="L431" rel="#L431">431</span>
<span id="L432" rel="#L432">432</span>
<span id="L433" rel="#L433">433</span>
<span id="L434" rel="#L434">434</span>
<span id="L435" rel="#L435">435</span>
<span id="L436" rel="#L436">436</span>
<span id="L437" rel="#L437">437</span>
<span id="L438" rel="#L438">438</span>
<span id="L439" rel="#L439">439</span>
<span id="L440" rel="#L440">440</span>
<span id="L441" rel="#L441">441</span>
<span id="L442" rel="#L442">442</span>
<span id="L443" rel="#L443">443</span>
<span id="L444" rel="#L444">444</span>
<span id="L445" rel="#L445">445</span>
<span id="L446" rel="#L446">446</span>
<span id="L447" rel="#L447">447</span>
<span id="L448" rel="#L448">448</span>
<span id="L449" rel="#L449">449</span>
<span id="L450" rel="#L450">450</span>
<span id="L451" rel="#L451">451</span>
<span id="L452" rel="#L452">452</span>
<span id="L453" rel="#L453">453</span>
<span id="L454" rel="#L454">454</span>
<span id="L455" rel="#L455">455</span>
<span id="L456" rel="#L456">456</span>
<span id="L457" rel="#L457">457</span>
<span id="L458" rel="#L458">458</span>
<span id="L459" rel="#L459">459</span>
<span id="L460" rel="#L460">460</span>
<span id="L461" rel="#L461">461</span>
<span id="L462" rel="#L462">462</span>
<span id="L463" rel="#L463">463</span>
<span id="L464" rel="#L464">464</span>
<span id="L465" rel="#L465">465</span>
<span id="L466" rel="#L466">466</span>
<span id="L467" rel="#L467">467</span>
<span id="L468" rel="#L468">468</span>
<span id="L469" rel="#L469">469</span>
<span id="L470" rel="#L470">470</span>
<span id="L471" rel="#L471">471</span>
<span id="L472" rel="#L472">472</span>
<span id="L473" rel="#L473">473</span>
<span id="L474" rel="#L474">474</span>
<span id="L475" rel="#L475">475</span>
<span id="L476" rel="#L476">476</span>
<span id="L477" rel="#L477">477</span>
<span id="L478" rel="#L478">478</span>
<span id="L479" rel="#L479">479</span>
<span id="L480" rel="#L480">480</span>
<span id="L481" rel="#L481">481</span>
<span id="L482" rel="#L482">482</span>
<span id="L483" rel="#L483">483</span>
<span id="L484" rel="#L484">484</span>
<span id="L485" rel="#L485">485</span>
<span id="L486" rel="#L486">486</span>
<span id="L487" rel="#L487">487</span>
<span id="L488" rel="#L488">488</span>
<span id="L489" rel="#L489">489</span>
<span id="L490" rel="#L490">490</span>
<span id="L491" rel="#L491">491</span>
<span id="L492" rel="#L492">492</span>
<span id="L493" rel="#L493">493</span>
<span id="L494" rel="#L494">494</span>
<span id="L495" rel="#L495">495</span>
<span id="L496" rel="#L496">496</span>
<span id="L497" rel="#L497">497</span>
<span id="L498" rel="#L498">498</span>
<span id="L499" rel="#L499">499</span>
<span id="L500" rel="#L500">500</span>
<span id="L501" rel="#L501">501</span>
<span id="L502" rel="#L502">502</span>
<span id="L503" rel="#L503">503</span>
<span id="L504" rel="#L504">504</span>
<span id="L505" rel="#L505">505</span>
<span id="L506" rel="#L506">506</span>
<span id="L507" rel="#L507">507</span>
<span id="L508" rel="#L508">508</span>
<span id="L509" rel="#L509">509</span>
<span id="L510" rel="#L510">510</span>
<span id="L511" rel="#L511">511</span>
<span id="L512" rel="#L512">512</span>
<span id="L513" rel="#L513">513</span>
<span id="L514" rel="#L514">514</span>
<span id="L515" rel="#L515">515</span>
<span id="L516" rel="#L516">516</span>
<span id="L517" rel="#L517">517</span>
<span id="L518" rel="#L518">518</span>
<span id="L519" rel="#L519">519</span>
<span id="L520" rel="#L520">520</span>
<span id="L521" rel="#L521">521</span>
<span id="L522" rel="#L522">522</span>
<span id="L523" rel="#L523">523</span>
<span id="L524" rel="#L524">524</span>
<span id="L525" rel="#L525">525</span>
<span id="L526" rel="#L526">526</span>
<span id="L527" rel="#L527">527</span>
<span id="L528" rel="#L528">528</span>
<span id="L529" rel="#L529">529</span>
<span id="L530" rel="#L530">530</span>
<span id="L531" rel="#L531">531</span>
<span id="L532" rel="#L532">532</span>
<span id="L533" rel="#L533">533</span>
<span id="L534" rel="#L534">534</span>
<span id="L535" rel="#L535">535</span>
<span id="L536" rel="#L536">536</span>
<span id="L537" rel="#L537">537</span>
<span id="L538" rel="#L538">538</span>
<span id="L539" rel="#L539">539</span>
<span id="L540" rel="#L540">540</span>
<span id="L541" rel="#L541">541</span>
<span id="L542" rel="#L542">542</span>
<span id="L543" rel="#L543">543</span>
<span id="L544" rel="#L544">544</span>
<span id="L545" rel="#L545">545</span>
<span id="L546" rel="#L546">546</span>
<span id="L547" rel="#L547">547</span>
<span id="L548" rel="#L548">548</span>
<span id="L549" rel="#L549">549</span>
<span id="L550" rel="#L550">550</span>
<span id="L551" rel="#L551">551</span>
<span id="L552" rel="#L552">552</span>
<span id="L553" rel="#L553">553</span>
<span id="L554" rel="#L554">554</span>
<span id="L555" rel="#L555">555</span>
<span id="L556" rel="#L556">556</span>
<span id="L557" rel="#L557">557</span>
<span id="L558" rel="#L558">558</span>
<span id="L559" rel="#L559">559</span>
<span id="L560" rel="#L560">560</span>
<span id="L561" rel="#L561">561</span>
<span id="L562" rel="#L562">562</span>
<span id="L563" rel="#L563">563</span>
<span id="L564" rel="#L564">564</span>
<span id="L565" rel="#L565">565</span>
<span id="L566" rel="#L566">566</span>
<span id="L567" rel="#L567">567</span>
<span id="L568" rel="#L568">568</span>
<span id="L569" rel="#L569">569</span>
<span id="L570" rel="#L570">570</span>
<span id="L571" rel="#L571">571</span>
<span id="L572" rel="#L572">572</span>
<span id="L573" rel="#L573">573</span>
<span id="L574" rel="#L574">574</span>
<span id="L575" rel="#L575">575</span>
<span id="L576" rel="#L576">576</span>
<span id="L577" rel="#L577">577</span>
<span id="L578" rel="#L578">578</span>
<span id="L579" rel="#L579">579</span>
<span id="L580" rel="#L580">580</span>
<span id="L581" rel="#L581">581</span>
<span id="L582" rel="#L582">582</span>
<span id="L583" rel="#L583">583</span>
<span id="L584" rel="#L584">584</span>
<span id="L585" rel="#L585">585</span>
<span id="L586" rel="#L586">586</span>
<span id="L587" rel="#L587">587</span>
<span id="L588" rel="#L588">588</span>
<span id="L589" rel="#L589">589</span>
<span id="L590" rel="#L590">590</span>
<span id="L591" rel="#L591">591</span>
<span id="L592" rel="#L592">592</span>
<span id="L593" rel="#L593">593</span>
<span id="L594" rel="#L594">594</span>
<span id="L595" rel="#L595">595</span>
<span id="L596" rel="#L596">596</span>
<span id="L597" rel="#L597">597</span>
<span id="L598" rel="#L598">598</span>
<span id="L599" rel="#L599">599</span>
<span id="L600" rel="#L600">600</span>
<span id="L601" rel="#L601">601</span>
<span id="L602" rel="#L602">602</span>
<span id="L603" rel="#L603">603</span>
<span id="L604" rel="#L604">604</span>
<span id="L605" rel="#L605">605</span>
<span id="L606" rel="#L606">606</span>
<span id="L607" rel="#L607">607</span>
<span id="L608" rel="#L608">608</span>
<span id="L609" rel="#L609">609</span>
<span id="L610" rel="#L610">610</span>
<span id="L611" rel="#L611">611</span>
<span id="L612" rel="#L612">612</span>
<span id="L613" rel="#L613">613</span>
<span id="L614" rel="#L614">614</span>
<span id="L615" rel="#L615">615</span>
<span id="L616" rel="#L616">616</span>
<span id="L617" rel="#L617">617</span>
<span id="L618" rel="#L618">618</span>
<span id="L619" rel="#L619">619</span>
<span id="L620" rel="#L620">620</span>
<span id="L621" rel="#L621">621</span>
<span id="L622" rel="#L622">622</span>
<span id="L623" rel="#L623">623</span>
<span id="L624" rel="#L624">624</span>
<span id="L625" rel="#L625">625</span>
<span id="L626" rel="#L626">626</span>
<span id="L627" rel="#L627">627</span>
<span id="L628" rel="#L628">628</span>
<span id="L629" rel="#L629">629</span>
<span id="L630" rel="#L630">630</span>
<span id="L631" rel="#L631">631</span>
<span id="L632" rel="#L632">632</span>
<span id="L633" rel="#L633">633</span>
<span id="L634" rel="#L634">634</span>
<span id="L635" rel="#L635">635</span>
<span id="L636" rel="#L636">636</span>
<span id="L637" rel="#L637">637</span>
<span id="L638" rel="#L638">638</span>
<span id="L639" rel="#L639">639</span>
<span id="L640" rel="#L640">640</span>
<span id="L641" rel="#L641">641</span>
<span id="L642" rel="#L642">642</span>
<span id="L643" rel="#L643">643</span>
<span id="L644" rel="#L644">644</span>
<span id="L645" rel="#L645">645</span>
<span id="L646" rel="#L646">646</span>
<span id="L647" rel="#L647">647</span>
<span id="L648" rel="#L648">648</span>
<span id="L649" rel="#L649">649</span>
<span id="L650" rel="#L650">650</span>
<span id="L651" rel="#L651">651</span>
<span id="L652" rel="#L652">652</span>
<span id="L653" rel="#L653">653</span>
<span id="L654" rel="#L654">654</span>
<span id="L655" rel="#L655">655</span>
<span id="L656" rel="#L656">656</span>
<span id="L657" rel="#L657">657</span>
<span id="L658" rel="#L658">658</span>
<span id="L659" rel="#L659">659</span>
<span id="L660" rel="#L660">660</span>
<span id="L661" rel="#L661">661</span>
<span id="L662" rel="#L662">662</span>
<span id="L663" rel="#L663">663</span>
<span id="L664" rel="#L664">664</span>
<span id="L665" rel="#L665">665</span>
<span id="L666" rel="#L666">666</span>
<span id="L667" rel="#L667">667</span>
<span id="L668" rel="#L668">668</span>
<span id="L669" rel="#L669">669</span>
<span id="L670" rel="#L670">670</span>
<span id="L671" rel="#L671">671</span>
<span id="L672" rel="#L672">672</span>
<span id="L673" rel="#L673">673</span>
<span id="L674" rel="#L674">674</span>
<span id="L675" rel="#L675">675</span>
<span id="L676" rel="#L676">676</span>
<span id="L677" rel="#L677">677</span>
<span id="L678" rel="#L678">678</span>
<span id="L679" rel="#L679">679</span>
<span id="L680" rel="#L680">680</span>
<span id="L681" rel="#L681">681</span>
<span id="L682" rel="#L682">682</span>
<span id="L683" rel="#L683">683</span>
<span id="L684" rel="#L684">684</span>
<span id="L685" rel="#L685">685</span>
<span id="L686" rel="#L686">686</span>
<span id="L687" rel="#L687">687</span>
<span id="L688" rel="#L688">688</span>
<span id="L689" rel="#L689">689</span>
<span id="L690" rel="#L690">690</span>
<span id="L691" rel="#L691">691</span>
<span id="L692" rel="#L692">692</span>
<span id="L693" rel="#L693">693</span>
<span id="L694" rel="#L694">694</span>
<span id="L695" rel="#L695">695</span>
<span id="L696" rel="#L696">696</span>
<span id="L697" rel="#L697">697</span>
<span id="L698" rel="#L698">698</span>
<span id="L699" rel="#L699">699</span>
<span id="L700" rel="#L700">700</span>
<span id="L701" rel="#L701">701</span>
<span id="L702" rel="#L702">702</span>
<span id="L703" rel="#L703">703</span>
<span id="L704" rel="#L704">704</span>
<span id="L705" rel="#L705">705</span>
<span id="L706" rel="#L706">706</span>
<span id="L707" rel="#L707">707</span>
<span id="L708" rel="#L708">708</span>
<span id="L709" rel="#L709">709</span>
<span id="L710" rel="#L710">710</span>
<span id="L711" rel="#L711">711</span>
<span id="L712" rel="#L712">712</span>
<span id="L713" rel="#L713">713</span>
<span id="L714" rel="#L714">714</span>
<span id="L715" rel="#L715">715</span>
<span id="L716" rel="#L716">716</span>
<span id="L717" rel="#L717">717</span>
<span id="L718" rel="#L718">718</span>
<span id="L719" rel="#L719">719</span>
<span id="L720" rel="#L720">720</span>
<span id="L721" rel="#L721">721</span>
<span id="L722" rel="#L722">722</span>
<span id="L723" rel="#L723">723</span>
<span id="L724" rel="#L724">724</span>
<span id="L725" rel="#L725">725</span>
<span id="L726" rel="#L726">726</span>
<span id="L727" rel="#L727">727</span>
<span id="L728" rel="#L728">728</span>
<span id="L729" rel="#L729">729</span>
<span id="L730" rel="#L730">730</span>
<span id="L731" rel="#L731">731</span>
<span id="L732" rel="#L732">732</span>
<span id="L733" rel="#L733">733</span>
<span id="L734" rel="#L734">734</span>
<span id="L735" rel="#L735">735</span>
<span id="L736" rel="#L736">736</span>
<span id="L737" rel="#L737">737</span>
<span id="L738" rel="#L738">738</span>
<span id="L739" rel="#L739">739</span>
<span id="L740" rel="#L740">740</span>
<span id="L741" rel="#L741">741</span>
<span id="L742" rel="#L742">742</span>
<span id="L743" rel="#L743">743</span>
<span id="L744" rel="#L744">744</span>
<span id="L745" rel="#L745">745</span>
<span id="L746" rel="#L746">746</span>
<span id="L747" rel="#L747">747</span>
<span id="L748" rel="#L748">748</span>
<span id="L749" rel="#L749">749</span>
<span id="L750" rel="#L750">750</span>
<span id="L751" rel="#L751">751</span>
<span id="L752" rel="#L752">752</span>
<span id="L753" rel="#L753">753</span>
<span id="L754" rel="#L754">754</span>
<span id="L755" rel="#L755">755</span>
<span id="L756" rel="#L756">756</span>
<span id="L757" rel="#L757">757</span>
<span id="L758" rel="#L758">758</span>
<span id="L759" rel="#L759">759</span>
<span id="L760" rel="#L760">760</span>
<span id="L761" rel="#L761">761</span>
<span id="L762" rel="#L762">762</span>
<span id="L763" rel="#L763">763</span>
<span id="L764" rel="#L764">764</span>
<span id="L765" rel="#L765">765</span>
<span id="L766" rel="#L766">766</span>
<span id="L767" rel="#L767">767</span>
<span id="L768" rel="#L768">768</span>
<span id="L769" rel="#L769">769</span>
<span id="L770" rel="#L770">770</span>
<span id="L771" rel="#L771">771</span>
<span id="L772" rel="#L772">772</span>
<span id="L773" rel="#L773">773</span>
<span id="L774" rel="#L774">774</span>
<span id="L775" rel="#L775">775</span>
<span id="L776" rel="#L776">776</span>
<span id="L777" rel="#L777">777</span>
<span id="L778" rel="#L778">778</span>
<span id="L779" rel="#L779">779</span>
<span id="L780" rel="#L780">780</span>
<span id="L781" rel="#L781">781</span>
<span id="L782" rel="#L782">782</span>
<span id="L783" rel="#L783">783</span>
<span id="L784" rel="#L784">784</span>
<span id="L785" rel="#L785">785</span>
<span id="L786" rel="#L786">786</span>
<span id="L787" rel="#L787">787</span>
<span id="L788" rel="#L788">788</span>
<span id="L789" rel="#L789">789</span>
<span id="L790" rel="#L790">790</span>
<span id="L791" rel="#L791">791</span>
<span id="L792" rel="#L792">792</span>
<span id="L793" rel="#L793">793</span>
<span id="L794" rel="#L794">794</span>
<span id="L795" rel="#L795">795</span>
<span id="L796" rel="#L796">796</span>
<span id="L797" rel="#L797">797</span>
<span id="L798" rel="#L798">798</span>
<span id="L799" rel="#L799">799</span>
<span id="L800" rel="#L800">800</span>
<span id="L801" rel="#L801">801</span>
<span id="L802" rel="#L802">802</span>
<span id="L803" rel="#L803">803</span>
<span id="L804" rel="#L804">804</span>
<span id="L805" rel="#L805">805</span>
<span id="L806" rel="#L806">806</span>
<span id="L807" rel="#L807">807</span>
<span id="L808" rel="#L808">808</span>
<span id="L809" rel="#L809">809</span>
<span id="L810" rel="#L810">810</span>
<span id="L811" rel="#L811">811</span>
<span id="L812" rel="#L812">812</span>
<span id="L813" rel="#L813">813</span>
<span id="L814" rel="#L814">814</span>
<span id="L815" rel="#L815">815</span>
<span id="L816" rel="#L816">816</span>
<span id="L817" rel="#L817">817</span>
<span id="L818" rel="#L818">818</span>
<span id="L819" rel="#L819">819</span>
<span id="L820" rel="#L820">820</span>
<span id="L821" rel="#L821">821</span>
<span id="L822" rel="#L822">822</span>
<span id="L823" rel="#L823">823</span>
<span id="L824" rel="#L824">824</span>
<span id="L825" rel="#L825">825</span>
<span id="L826" rel="#L826">826</span>
<span id="L827" rel="#L827">827</span>
<span id="L828" rel="#L828">828</span>
<span id="L829" rel="#L829">829</span>
<span id="L830" rel="#L830">830</span>
<span id="L831" rel="#L831">831</span>
<span id="L832" rel="#L832">832</span>
<span id="L833" rel="#L833">833</span>
<span id="L834" rel="#L834">834</span>
<span id="L835" rel="#L835">835</span>
<span id="L836" rel="#L836">836</span>
<span id="L837" rel="#L837">837</span>
<span id="L838" rel="#L838">838</span>
<span id="L839" rel="#L839">839</span>
<span id="L840" rel="#L840">840</span>
<span id="L841" rel="#L841">841</span>
<span id="L842" rel="#L842">842</span>
<span id="L843" rel="#L843">843</span>
<span id="L844" rel="#L844">844</span>
<span id="L845" rel="#L845">845</span>
<span id="L846" rel="#L846">846</span>
<span id="L847" rel="#L847">847</span>
<span id="L848" rel="#L848">848</span>
<span id="L849" rel="#L849">849</span>
<span id="L850" rel="#L850">850</span>
<span id="L851" rel="#L851">851</span>
<span id="L852" rel="#L852">852</span>
<span id="L853" rel="#L853">853</span>
<span id="L854" rel="#L854">854</span>
<span id="L855" rel="#L855">855</span>
<span id="L856" rel="#L856">856</span>
<span id="L857" rel="#L857">857</span>
<span id="L858" rel="#L858">858</span>
<span id="L859" rel="#L859">859</span>
<span id="L860" rel="#L860">860</span>
<span id="L861" rel="#L861">861</span>
<span id="L862" rel="#L862">862</span>
<span id="L863" rel="#L863">863</span>
<span id="L864" rel="#L864">864</span>
<span id="L865" rel="#L865">865</span>
<span id="L866" rel="#L866">866</span>
<span id="L867" rel="#L867">867</span>
<span id="L868" rel="#L868">868</span>
<span id="L869" rel="#L869">869</span>
<span id="L870" rel="#L870">870</span>
<span id="L871" rel="#L871">871</span>
<span id="L872" rel="#L872">872</span>
<span id="L873" rel="#L873">873</span>
<span id="L874" rel="#L874">874</span>
<span id="L875" rel="#L875">875</span>
<span id="L876" rel="#L876">876</span>
<span id="L877" rel="#L877">877</span>
<span id="L878" rel="#L878">878</span>
<span id="L879" rel="#L879">879</span>
<span id="L880" rel="#L880">880</span>
<span id="L881" rel="#L881">881</span>
<span id="L882" rel="#L882">882</span>
<span id="L883" rel="#L883">883</span>
<span id="L884" rel="#L884">884</span>
<span id="L885" rel="#L885">885</span>
<span id="L886" rel="#L886">886</span>
<span id="L887" rel="#L887">887</span>
<span id="L888" rel="#L888">888</span>
<span id="L889" rel="#L889">889</span>
<span id="L890" rel="#L890">890</span>
<span id="L891" rel="#L891">891</span>
<span id="L892" rel="#L892">892</span>
<span id="L893" rel="#L893">893</span>
<span id="L894" rel="#L894">894</span>
<span id="L895" rel="#L895">895</span>
<span id="L896" rel="#L896">896</span>
<span id="L897" rel="#L897">897</span>
<span id="L898" rel="#L898">898</span>
<span id="L899" rel="#L899">899</span>
<span id="L900" rel="#L900">900</span>
<span id="L901" rel="#L901">901</span>
<span id="L902" rel="#L902">902</span>
<span id="L903" rel="#L903">903</span>
<span id="L904" rel="#L904">904</span>
<span id="L905" rel="#L905">905</span>
<span id="L906" rel="#L906">906</span>
<span id="L907" rel="#L907">907</span>
<span id="L908" rel="#L908">908</span>
<span id="L909" rel="#L909">909</span>
<span id="L910" rel="#L910">910</span>
<span id="L911" rel="#L911">911</span>
<span id="L912" rel="#L912">912</span>
<span id="L913" rel="#L913">913</span>
<span id="L914" rel="#L914">914</span>
<span id="L915" rel="#L915">915</span>
<span id="L916" rel="#L916">916</span>
<span id="L917" rel="#L917">917</span>
<span id="L918" rel="#L918">918</span>
<span id="L919" rel="#L919">919</span>
<span id="L920" rel="#L920">920</span>
<span id="L921" rel="#L921">921</span>
<span id="L922" rel="#L922">922</span>
<span id="L923" rel="#L923">923</span>
<span id="L924" rel="#L924">924</span>
<span id="L925" rel="#L925">925</span>
<span id="L926" rel="#L926">926</span>
<span id="L927" rel="#L927">927</span>
<span id="L928" rel="#L928">928</span>
<span id="L929" rel="#L929">929</span>
<span id="L930" rel="#L930">930</span>
<span id="L931" rel="#L931">931</span>
<span id="L932" rel="#L932">932</span>
<span id="L933" rel="#L933">933</span>
<span id="L934" rel="#L934">934</span>
<span id="L935" rel="#L935">935</span>
<span id="L936" rel="#L936">936</span>
<span id="L937" rel="#L937">937</span>
<span id="L938" rel="#L938">938</span>
<span id="L939" rel="#L939">939</span>
<span id="L940" rel="#L940">940</span>
<span id="L941" rel="#L941">941</span>
<span id="L942" rel="#L942">942</span>
<span id="L943" rel="#L943">943</span>
<span id="L944" rel="#L944">944</span>
<span id="L945" rel="#L945">945</span>
<span id="L946" rel="#L946">946</span>
<span id="L947" rel="#L947">947</span>
<span id="L948" rel="#L948">948</span>
<span id="L949" rel="#L949">949</span>
<span id="L950" rel="#L950">950</span>
<span id="L951" rel="#L951">951</span>
<span id="L952" rel="#L952">952</span>
<span id="L953" rel="#L953">953</span>
<span id="L954" rel="#L954">954</span>
<span id="L955" rel="#L955">955</span>
<span id="L956" rel="#L956">956</span>
<span id="L957" rel="#L957">957</span>
<span id="L958" rel="#L958">958</span>
<span id="L959" rel="#L959">959</span>
<span id="L960" rel="#L960">960</span>
<span id="L961" rel="#L961">961</span>
<span id="L962" rel="#L962">962</span>
<span id="L963" rel="#L963">963</span>
<span id="L964" rel="#L964">964</span>
<span id="L965" rel="#L965">965</span>
<span id="L966" rel="#L966">966</span>
<span id="L967" rel="#L967">967</span>
<span id="L968" rel="#L968">968</span>
<span id="L969" rel="#L969">969</span>
<span id="L970" rel="#L970">970</span>
<span id="L971" rel="#L971">971</span>
<span id="L972" rel="#L972">972</span>
<span id="L973" rel="#L973">973</span>
<span id="L974" rel="#L974">974</span>
<span id="L975" rel="#L975">975</span>
<span id="L976" rel="#L976">976</span>
<span id="L977" rel="#L977">977</span>
<span id="L978" rel="#L978">978</span>
<span id="L979" rel="#L979">979</span>
<span id="L980" rel="#L980">980</span>
<span id="L981" rel="#L981">981</span>
<span id="L982" rel="#L982">982</span>
<span id="L983" rel="#L983">983</span>
<span id="L984" rel="#L984">984</span>
<span id="L985" rel="#L985">985</span>
<span id="L986" rel="#L986">986</span>
<span id="L987" rel="#L987">987</span>
<span id="L988" rel="#L988">988</span>
<span id="L989" rel="#L989">989</span>
<span id="L990" rel="#L990">990</span>
<span id="L991" rel="#L991">991</span>
<span id="L992" rel="#L992">992</span>
<span id="L993" rel="#L993">993</span>
<span id="L994" rel="#L994">994</span>
<span id="L995" rel="#L995">995</span>
<span id="L996" rel="#L996">996</span>
<span id="L997" rel="#L997">997</span>
<span id="L998" rel="#L998">998</span>
<span id="L999" rel="#L999">999</span>
<span id="L1000" rel="#L1000">1000</span>
<span id="L1001" rel="#L1001">1001</span>
<span id="L1002" rel="#L1002">1002</span>
<span id="L1003" rel="#L1003">1003</span>
<span id="L1004" rel="#L1004">1004</span>
<span id="L1005" rel="#L1005">1005</span>
<span id="L1006" rel="#L1006">1006</span>
<span id="L1007" rel="#L1007">1007</span>
<span id="L1008" rel="#L1008">1008</span>
<span id="L1009" rel="#L1009">1009</span>
<span id="L1010" rel="#L1010">1010</span>
<span id="L1011" rel="#L1011">1011</span>
<span id="L1012" rel="#L1012">1012</span>
<span id="L1013" rel="#L1013">1013</span>
<span id="L1014" rel="#L1014">1014</span>
<span id="L1015" rel="#L1015">1015</span>
<span id="L1016" rel="#L1016">1016</span>
<span id="L1017" rel="#L1017">1017</span>
<span id="L1018" rel="#L1018">1018</span>
<span id="L1019" rel="#L1019">1019</span>
<span id="L1020" rel="#L1020">1020</span>
<span id="L1021" rel="#L1021">1021</span>
<span id="L1022" rel="#L1022">1022</span>
<span id="L1023" rel="#L1023">1023</span>
<span id="L1024" rel="#L1024">1024</span>
<span id="L1025" rel="#L1025">1025</span>
<span id="L1026" rel="#L1026">1026</span>
<span id="L1027" rel="#L1027">1027</span>
<span id="L1028" rel="#L1028">1028</span>
<span id="L1029" rel="#L1029">1029</span>
<span id="L1030" rel="#L1030">1030</span>
<span id="L1031" rel="#L1031">1031</span>
<span id="L1032" rel="#L1032">1032</span>
<span id="L1033" rel="#L1033">1033</span>
<span id="L1034" rel="#L1034">1034</span>
<span id="L1035" rel="#L1035">1035</span>
<span id="L1036" rel="#L1036">1036</span>
<span id="L1037" rel="#L1037">1037</span>
<span id="L1038" rel="#L1038">1038</span>
<span id="L1039" rel="#L1039">1039</span>
<span id="L1040" rel="#L1040">1040</span>
<span id="L1041" rel="#L1041">1041</span>
<span id="L1042" rel="#L1042">1042</span>
<span id="L1043" rel="#L1043">1043</span>
<span id="L1044" rel="#L1044">1044</span>
<span id="L1045" rel="#L1045">1045</span>
<span id="L1046" rel="#L1046">1046</span>
<span id="L1047" rel="#L1047">1047</span>
<span id="L1048" rel="#L1048">1048</span>
<span id="L1049" rel="#L1049">1049</span>
<span id="L1050" rel="#L1050">1050</span>
<span id="L1051" rel="#L1051">1051</span>
<span id="L1052" rel="#L1052">1052</span>
<span id="L1053" rel="#L1053">1053</span>
<span id="L1054" rel="#L1054">1054</span>
<span id="L1055" rel="#L1055">1055</span>
<span id="L1056" rel="#L1056">1056</span>
<span id="L1057" rel="#L1057">1057</span>
<span id="L1058" rel="#L1058">1058</span>
<span id="L1059" rel="#L1059">1059</span>
<span id="L1060" rel="#L1060">1060</span>
<span id="L1061" rel="#L1061">1061</span>
<span id="L1062" rel="#L1062">1062</span>
<span id="L1063" rel="#L1063">1063</span>
<span id="L1064" rel="#L1064">1064</span>
<span id="L1065" rel="#L1065">1065</span>
<span id="L1066" rel="#L1066">1066</span>
<span id="L1067" rel="#L1067">1067</span>
<span id="L1068" rel="#L1068">1068</span>
<span id="L1069" rel="#L1069">1069</span>
<span id="L1070" rel="#L1070">1070</span>
<span id="L1071" rel="#L1071">1071</span>
<span id="L1072" rel="#L1072">1072</span>
<span id="L1073" rel="#L1073">1073</span>
<span id="L1074" rel="#L1074">1074</span>
<span id="L1075" rel="#L1075">1075</span>
<span id="L1076" rel="#L1076">1076</span>
<span id="L1077" rel="#L1077">1077</span>
<span id="L1078" rel="#L1078">1078</span>
<span id="L1079" rel="#L1079">1079</span>
<span id="L1080" rel="#L1080">1080</span>
<span id="L1081" rel="#L1081">1081</span>
<span id="L1082" rel="#L1082">1082</span>
<span id="L1083" rel="#L1083">1083</span>
<span id="L1084" rel="#L1084">1084</span>
<span id="L1085" rel="#L1085">1085</span>
<span id="L1086" rel="#L1086">1086</span>
<span id="L1087" rel="#L1087">1087</span>
<span id="L1088" rel="#L1088">1088</span>
<span id="L1089" rel="#L1089">1089</span>
<span id="L1090" rel="#L1090">1090</span>
<span id="L1091" rel="#L1091">1091</span>
<span id="L1092" rel="#L1092">1092</span>
<span id="L1093" rel="#L1093">1093</span>
<span id="L1094" rel="#L1094">1094</span>
<span id="L1095" rel="#L1095">1095</span>
<span id="L1096" rel="#L1096">1096</span>
<span id="L1097" rel="#L1097">1097</span>
<span id="L1098" rel="#L1098">1098</span>
<span id="L1099" rel="#L1099">1099</span>
<span id="L1100" rel="#L1100">1100</span>
<span id="L1101" rel="#L1101">1101</span>
<span id="L1102" rel="#L1102">1102</span>
<span id="L1103" rel="#L1103">1103</span>
<span id="L1104" rel="#L1104">1104</span>
<span id="L1105" rel="#L1105">1105</span>
<span id="L1106" rel="#L1106">1106</span>
<span id="L1107" rel="#L1107">1107</span>
<span id="L1108" rel="#L1108">1108</span>
<span id="L1109" rel="#L1109">1109</span>
<span id="L1110" rel="#L1110">1110</span>
<span id="L1111" rel="#L1111">1111</span>
<span id="L1112" rel="#L1112">1112</span>
<span id="L1113" rel="#L1113">1113</span>
<span id="L1114" rel="#L1114">1114</span>
<span id="L1115" rel="#L1115">1115</span>
<span id="L1116" rel="#L1116">1116</span>
<span id="L1117" rel="#L1117">1117</span>
<span id="L1118" rel="#L1118">1118</span>
<span id="L1119" rel="#L1119">1119</span>
<span id="L1120" rel="#L1120">1120</span>
<span id="L1121" rel="#L1121">1121</span>
<span id="L1122" rel="#L1122">1122</span>
<span id="L1123" rel="#L1123">1123</span>
<span id="L1124" rel="#L1124">1124</span>
<span id="L1125" rel="#L1125">1125</span>
<span id="L1126" rel="#L1126">1126</span>
<span id="L1127" rel="#L1127">1127</span>
<span id="L1128" rel="#L1128">1128</span>
<span id="L1129" rel="#L1129">1129</span>
<span id="L1130" rel="#L1130">1130</span>
<span id="L1131" rel="#L1131">1131</span>
<span id="L1132" rel="#L1132">1132</span>
<span id="L1133" rel="#L1133">1133</span>
<span id="L1134" rel="#L1134">1134</span>
<span id="L1135" rel="#L1135">1135</span>
<span id="L1136" rel="#L1136">1136</span>
<span id="L1137" rel="#L1137">1137</span>
<span id="L1138" rel="#L1138">1138</span>
<span id="L1139" rel="#L1139">1139</span>
<span id="L1140" rel="#L1140">1140</span>
<span id="L1141" rel="#L1141">1141</span>
<span id="L1142" rel="#L1142">1142</span>
<span id="L1143" rel="#L1143">1143</span>
<span id="L1144" rel="#L1144">1144</span>
<span id="L1145" rel="#L1145">1145</span>
<span id="L1146" rel="#L1146">1146</span>
<span id="L1147" rel="#L1147">1147</span>
<span id="L1148" rel="#L1148">1148</span>
<span id="L1149" rel="#L1149">1149</span>
<span id="L1150" rel="#L1150">1150</span>
<span id="L1151" rel="#L1151">1151</span>
<span id="L1152" rel="#L1152">1152</span>
<span id="L1153" rel="#L1153">1153</span>
<span id="L1154" rel="#L1154">1154</span>
<span id="L1155" rel="#L1155">1155</span>
<span id="L1156" rel="#L1156">1156</span>
<span id="L1157" rel="#L1157">1157</span>
<span id="L1158" rel="#L1158">1158</span>
<span id="L1159" rel="#L1159">1159</span>
<span id="L1160" rel="#L1160">1160</span>
<span id="L1161" rel="#L1161">1161</span>
<span id="L1162" rel="#L1162">1162</span>
<span id="L1163" rel="#L1163">1163</span>
<span id="L1164" rel="#L1164">1164</span>
<span id="L1165" rel="#L1165">1165</span>
<span id="L1166" rel="#L1166">1166</span>
<span id="L1167" rel="#L1167">1167</span>
<span id="L1168" rel="#L1168">1168</span>
<span id="L1169" rel="#L1169">1169</span>
<span id="L1170" rel="#L1170">1170</span>
<span id="L1171" rel="#L1171">1171</span>
<span id="L1172" rel="#L1172">1172</span>
<span id="L1173" rel="#L1173">1173</span>
<span id="L1174" rel="#L1174">1174</span>
<span id="L1175" rel="#L1175">1175</span>
<span id="L1176" rel="#L1176">1176</span>
<span id="L1177" rel="#L1177">1177</span>
<span id="L1178" rel="#L1178">1178</span>
<span id="L1179" rel="#L1179">1179</span>
<span id="L1180" rel="#L1180">1180</span>
<span id="L1181" rel="#L1181">1181</span>
<span id="L1182" rel="#L1182">1182</span>
<span id="L1183" rel="#L1183">1183</span>
<span id="L1184" rel="#L1184">1184</span>
<span id="L1185" rel="#L1185">1185</span>
<span id="L1186" rel="#L1186">1186</span>
<span id="L1187" rel="#L1187">1187</span>
<span id="L1188" rel="#L1188">1188</span>
<span id="L1189" rel="#L1189">1189</span>
<span id="L1190" rel="#L1190">1190</span>
<span id="L1191" rel="#L1191">1191</span>
<span id="L1192" rel="#L1192">1192</span>
<span id="L1193" rel="#L1193">1193</span>
<span id="L1194" rel="#L1194">1194</span>
<span id="L1195" rel="#L1195">1195</span>
<span id="L1196" rel="#L1196">1196</span>
<span id="L1197" rel="#L1197">1197</span>
<span id="L1198" rel="#L1198">1198</span>
<span id="L1199" rel="#L1199">1199</span>
<span id="L1200" rel="#L1200">1200</span>
<span id="L1201" rel="#L1201">1201</span>
<span id="L1202" rel="#L1202">1202</span>
<span id="L1203" rel="#L1203">1203</span>
<span id="L1204" rel="#L1204">1204</span>
<span id="L1205" rel="#L1205">1205</span>
<span id="L1206" rel="#L1206">1206</span>
<span id="L1207" rel="#L1207">1207</span>
<span id="L1208" rel="#L1208">1208</span>
<span id="L1209" rel="#L1209">1209</span>
<span id="L1210" rel="#L1210">1210</span>
<span id="L1211" rel="#L1211">1211</span>
<span id="L1212" rel="#L1212">1212</span>
<span id="L1213" rel="#L1213">1213</span>
<span id="L1214" rel="#L1214">1214</span>
<span id="L1215" rel="#L1215">1215</span>
<span id="L1216" rel="#L1216">1216</span>
<span id="L1217" rel="#L1217">1217</span>
<span id="L1218" rel="#L1218">1218</span>
<span id="L1219" rel="#L1219">1219</span>
<span id="L1220" rel="#L1220">1220</span>
<span id="L1221" rel="#L1221">1221</span>
<span id="L1222" rel="#L1222">1222</span>
<span id="L1223" rel="#L1223">1223</span>
<span id="L1224" rel="#L1224">1224</span>
<span id="L1225" rel="#L1225">1225</span>
<span id="L1226" rel="#L1226">1226</span>
<span id="L1227" rel="#L1227">1227</span>
<span id="L1228" rel="#L1228">1228</span>
<span id="L1229" rel="#L1229">1229</span>
<span id="L1230" rel="#L1230">1230</span>
<span id="L1231" rel="#L1231">1231</span>
<span id="L1232" rel="#L1232">1232</span>
<span id="L1233" rel="#L1233">1233</span>
<span id="L1234" rel="#L1234">1234</span>
<span id="L1235" rel="#L1235">1235</span>
<span id="L1236" rel="#L1236">1236</span>
<span id="L1237" rel="#L1237">1237</span>
<span id="L1238" rel="#L1238">1238</span>
<span id="L1239" rel="#L1239">1239</span>
<span id="L1240" rel="#L1240">1240</span>
<span id="L1241" rel="#L1241">1241</span>
<span id="L1242" rel="#L1242">1242</span>
<span id="L1243" rel="#L1243">1243</span>
<span id="L1244" rel="#L1244">1244</span>
<span id="L1245" rel="#L1245">1245</span>
<span id="L1246" rel="#L1246">1246</span>
<span id="L1247" rel="#L1247">1247</span>
<span id="L1248" rel="#L1248">1248</span>
<span id="L1249" rel="#L1249">1249</span>
<span id="L1250" rel="#L1250">1250</span>
<span id="L1251" rel="#L1251">1251</span>
<span id="L1252" rel="#L1252">1252</span>
<span id="L1253" rel="#L1253">1253</span>
<span id="L1254" rel="#L1254">1254</span>
<span id="L1255" rel="#L1255">1255</span>
<span id="L1256" rel="#L1256">1256</span>
<span id="L1257" rel="#L1257">1257</span>
<span id="L1258" rel="#L1258">1258</span>
<span id="L1259" rel="#L1259">1259</span>
<span id="L1260" rel="#L1260">1260</span>
<span id="L1261" rel="#L1261">1261</span>
<span id="L1262" rel="#L1262">1262</span>
<span id="L1263" rel="#L1263">1263</span>
<span id="L1264" rel="#L1264">1264</span>
<span id="L1265" rel="#L1265">1265</span>
<span id="L1266" rel="#L1266">1266</span>
<span id="L1267" rel="#L1267">1267</span>
<span id="L1268" rel="#L1268">1268</span>
<span id="L1269" rel="#L1269">1269</span>
<span id="L1270" rel="#L1270">1270</span>
<span id="L1271" rel="#L1271">1271</span>
<span id="L1272" rel="#L1272">1272</span>
<span id="L1273" rel="#L1273">1273</span>
<span id="L1274" rel="#L1274">1274</span>
<span id="L1275" rel="#L1275">1275</span>
<span id="L1276" rel="#L1276">1276</span>
<span id="L1277" rel="#L1277">1277</span>
<span id="L1278" rel="#L1278">1278</span>
<span id="L1279" rel="#L1279">1279</span>
<span id="L1280" rel="#L1280">1280</span>
<span id="L1281" rel="#L1281">1281</span>
<span id="L1282" rel="#L1282">1282</span>
<span id="L1283" rel="#L1283">1283</span>
<span id="L1284" rel="#L1284">1284</span>
<span id="L1285" rel="#L1285">1285</span>
<span id="L1286" rel="#L1286">1286</span>
<span id="L1287" rel="#L1287">1287</span>
<span id="L1288" rel="#L1288">1288</span>
<span id="L1289" rel="#L1289">1289</span>
<span id="L1290" rel="#L1290">1290</span>
<span id="L1291" rel="#L1291">1291</span>
<span id="L1292" rel="#L1292">1292</span>
<span id="L1293" rel="#L1293">1293</span>
<span id="L1294" rel="#L1294">1294</span>
<span id="L1295" rel="#L1295">1295</span>
<span id="L1296" rel="#L1296">1296</span>
<span id="L1297" rel="#L1297">1297</span>
<span id="L1298" rel="#L1298">1298</span>
<span id="L1299" rel="#L1299">1299</span>
<span id="L1300" rel="#L1300">1300</span>
<span id="L1301" rel="#L1301">1301</span>
<span id="L1302" rel="#L1302">1302</span>
<span id="L1303" rel="#L1303">1303</span>
<span id="L1304" rel="#L1304">1304</span>
<span id="L1305" rel="#L1305">1305</span>
<span id="L1306" rel="#L1306">1306</span>
<span id="L1307" rel="#L1307">1307</span>
<span id="L1308" rel="#L1308">1308</span>
<span id="L1309" rel="#L1309">1309</span>
<span id="L1310" rel="#L1310">1310</span>
<span id="L1311" rel="#L1311">1311</span>
<span id="L1312" rel="#L1312">1312</span>
<span id="L1313" rel="#L1313">1313</span>
<span id="L1314" rel="#L1314">1314</span>
<span id="L1315" rel="#L1315">1315</span>
<span id="L1316" rel="#L1316">1316</span>
<span id="L1317" rel="#L1317">1317</span>
<span id="L1318" rel="#L1318">1318</span>
<span id="L1319" rel="#L1319">1319</span>
<span id="L1320" rel="#L1320">1320</span>
<span id="L1321" rel="#L1321">1321</span>
<span id="L1322" rel="#L1322">1322</span>
<span id="L1323" rel="#L1323">1323</span>
<span id="L1324" rel="#L1324">1324</span>
<span id="L1325" rel="#L1325">1325</span>
<span id="L1326" rel="#L1326">1326</span>
<span id="L1327" rel="#L1327">1327</span>
<span id="L1328" rel="#L1328">1328</span>
<span id="L1329" rel="#L1329">1329</span>
<span id="L1330" rel="#L1330">1330</span>
<span id="L1331" rel="#L1331">1331</span>
<span id="L1332" rel="#L1332">1332</span>
<span id="L1333" rel="#L1333">1333</span>
<span id="L1334" rel="#L1334">1334</span>
<span id="L1335" rel="#L1335">1335</span>
<span id="L1336" rel="#L1336">1336</span>
<span id="L1337" rel="#L1337">1337</span>
<span id="L1338" rel="#L1338">1338</span>
<span id="L1339" rel="#L1339">1339</span>
<span id="L1340" rel="#L1340">1340</span>
<span id="L1341" rel="#L1341">1341</span>
<span id="L1342" rel="#L1342">1342</span>
<span id="L1343" rel="#L1343">1343</span>
<span id="L1344" rel="#L1344">1344</span>
<span id="L1345" rel="#L1345">1345</span>
<span id="L1346" rel="#L1346">1346</span>
<span id="L1347" rel="#L1347">1347</span>
<span id="L1348" rel="#L1348">1348</span>
<span id="L1349" rel="#L1349">1349</span>
<span id="L1350" rel="#L1350">1350</span>
<span id="L1351" rel="#L1351">1351</span>
<span id="L1352" rel="#L1352">1352</span>
<span id="L1353" rel="#L1353">1353</span>
<span id="L1354" rel="#L1354">1354</span>
<span id="L1355" rel="#L1355">1355</span>
<span id="L1356" rel="#L1356">1356</span>
<span id="L1357" rel="#L1357">1357</span>
<span id="L1358" rel="#L1358">1358</span>
<span id="L1359" rel="#L1359">1359</span>
<span id="L1360" rel="#L1360">1360</span>
<span id="L1361" rel="#L1361">1361</span>
<span id="L1362" rel="#L1362">1362</span>
<span id="L1363" rel="#L1363">1363</span>
<span id="L1364" rel="#L1364">1364</span>
<span id="L1365" rel="#L1365">1365</span>
<span id="L1366" rel="#L1366">1366</span>
<span id="L1367" rel="#L1367">1367</span>
<span id="L1368" rel="#L1368">1368</span>
<span id="L1369" rel="#L1369">1369</span>
<span id="L1370" rel="#L1370">1370</span>
<span id="L1371" rel="#L1371">1371</span>
<span id="L1372" rel="#L1372">1372</span>
<span id="L1373" rel="#L1373">1373</span>
<span id="L1374" rel="#L1374">1374</span>
<span id="L1375" rel="#L1375">1375</span>
<span id="L1376" rel="#L1376">1376</span>
<span id="L1377" rel="#L1377">1377</span>
<span id="L1378" rel="#L1378">1378</span>
<span id="L1379" rel="#L1379">1379</span>
<span id="L1380" rel="#L1380">1380</span>
<span id="L1381" rel="#L1381">1381</span>
<span id="L1382" rel="#L1382">1382</span>
<span id="L1383" rel="#L1383">1383</span>
<span id="L1384" rel="#L1384">1384</span>
<span id="L1385" rel="#L1385">1385</span>
<span id="L1386" rel="#L1386">1386</span>
<span id="L1387" rel="#L1387">1387</span>
<span id="L1388" rel="#L1388">1388</span>
<span id="L1389" rel="#L1389">1389</span>
<span id="L1390" rel="#L1390">1390</span>
<span id="L1391" rel="#L1391">1391</span>
<span id="L1392" rel="#L1392">1392</span>
<span id="L1393" rel="#L1393">1393</span>
<span id="L1394" rel="#L1394">1394</span>
<span id="L1395" rel="#L1395">1395</span>
<span id="L1396" rel="#L1396">1396</span>
<span id="L1397" rel="#L1397">1397</span>
<span id="L1398" rel="#L1398">1398</span>
<span id="L1399" rel="#L1399">1399</span>
<span id="L1400" rel="#L1400">1400</span>
<span id="L1401" rel="#L1401">1401</span>
<span id="L1402" rel="#L1402">1402</span>
<span id="L1403" rel="#L1403">1403</span>
<span id="L1404" rel="#L1404">1404</span>
<span id="L1405" rel="#L1405">1405</span>
<span id="L1406" rel="#L1406">1406</span>
<span id="L1407" rel="#L1407">1407</span>
<span id="L1408" rel="#L1408">1408</span>
<span id="L1409" rel="#L1409">1409</span>
<span id="L1410" rel="#L1410">1410</span>
<span id="L1411" rel="#L1411">1411</span>
<span id="L1412" rel="#L1412">1412</span>
<span id="L1413" rel="#L1413">1413</span>
<span id="L1414" rel="#L1414">1414</span>
<span id="L1415" rel="#L1415">1415</span>
<span id="L1416" rel="#L1416">1416</span>
<span id="L1417" rel="#L1417">1417</span>
<span id="L1418" rel="#L1418">1418</span>
<span id="L1419" rel="#L1419">1419</span>
<span id="L1420" rel="#L1420">1420</span>
<span id="L1421" rel="#L1421">1421</span>
<span id="L1422" rel="#L1422">1422</span>
<span id="L1423" rel="#L1423">1423</span>
<span id="L1424" rel="#L1424">1424</span>
<span id="L1425" rel="#L1425">1425</span>
<span id="L1426" rel="#L1426">1426</span>
<span id="L1427" rel="#L1427">1427</span>
<span id="L1428" rel="#L1428">1428</span>
</pre>
          </td>
          <td width="100%">
            
              
                <div class="highlight"><pre><div class='line' id='LC1'><span class="cm">/*</span></div><div class='line' id='LC2'><span class="cm"> * Copyright (c) 2010 - The OWASP Foundation</span></div><div class='line' id='LC3'><span class="cm"> *</span></div><div class='line' id='LC4'><span class="cm"> * The jquery-encoder is published by OWASP under the MIT license. You should read and accept the</span></div><div class='line' id='LC5'><span class="cm"> * LICENSE before you use, modify, and/or redistribute this software.</span></div><div class='line' id='LC6'><span class="cm"> */</span></div><div class='line' id='LC7'><span class="p">(</span><span class="kd">function</span><span class="p">(</span><span class="nx">$</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC8'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">default_immune</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC9'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;js&#39;</span>        <span class="o">:</span> <span class="p">[</span><span class="s1">&#39;,&#39;</span><span class="p">,</span><span class="s1">&#39;.&#39;</span><span class="p">,</span><span class="s1">&#39;_&#39;</span><span class="p">,</span><span class="s1">&#39; &#39;</span><span class="p">]</span></div><div class='line' id='LC10'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC11'><br/></div><div class='line' id='LC12'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">attr_whitelist_classes</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC13'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;default&#39;</span><span class="o">:</span> <span class="p">[</span><span class="s1">&#39;,&#39;</span><span class="p">,</span><span class="s1">&#39;.&#39;</span><span class="p">,</span><span class="s1">&#39;-&#39;</span><span class="p">,</span><span class="s1">&#39;_&#39;</span><span class="p">,</span><span class="s1">&#39; &#39;</span><span class="p">]</span></div><div class='line' id='LC14'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC15'><br/></div><div class='line' id='LC16'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">attr_whitelist</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC17'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;width&#39;</span><span class="o">:</span> <span class="p">[</span><span class="s1">&#39;%&#39;</span><span class="p">],</span></div><div class='line' id='LC18'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;height&#39;</span><span class="o">:</span> <span class="p">[</span><span class="s1">&#39;%&#39;</span><span class="p">]</span></div><div class='line' id='LC19'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC20'><br/></div><div class='line' id='LC21'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">css_whitelist_classes</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC22'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;default&#39;</span><span class="o">:</span> <span class="p">[</span><span class="s1">&#39;-&#39;</span><span class="p">,</span><span class="s1">&#39; &#39;</span><span class="p">,</span><span class="s1">&#39;%&#39;</span><span class="p">],</span></div><div class='line' id='LC23'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;color&#39;</span><span class="o">:</span> <span class="p">[</span><span class="s1">&#39;#&#39;</span><span class="p">,</span><span class="s1">&#39; &#39;</span><span class="p">,</span><span class="s1">&#39;(&#39;</span><span class="p">,</span><span class="s1">&#39;)&#39;</span><span class="p">],</span></div><div class='line' id='LC24'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;image&#39;</span><span class="o">:</span> <span class="p">[</span><span class="s1">&#39;(&#39;</span><span class="p">,</span><span class="s1">&#39;)&#39;</span><span class="p">,</span><span class="s1">&#39;:&#39;</span><span class="p">,</span><span class="s1">&#39;/&#39;</span><span class="p">,</span><span class="s1">&#39;?&#39;</span><span class="p">,</span><span class="s1">&#39;&amp;&#39;</span><span class="p">,</span><span class="s1">&#39;-&#39;</span><span class="p">,</span><span class="s1">&#39;.&#39;</span><span class="p">,</span><span class="s1">&#39;&quot;&#39;</span><span class="p">,</span><span class="s1">&#39;=&#39;</span><span class="p">,</span><span class="s1">&#39; &#39;</span><span class="p">]</span></div><div class='line' id='LC25'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC26'><br/></div><div class='line' id='LC27'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">css_whitelist</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC28'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;background&#39;</span><span class="o">:</span> <span class="p">[</span><span class="s1">&#39;(&#39;</span><span class="p">,</span><span class="s1">&#39;)&#39;</span><span class="p">,</span><span class="s1">&#39;:&#39;</span><span class="p">,</span><span class="s1">&#39;%&#39;</span><span class="p">,</span><span class="s1">&#39;/&#39;</span><span class="p">,</span><span class="s1">&#39;?&#39;</span><span class="p">,</span><span class="s1">&#39;&amp;&#39;</span><span class="p">,</span><span class="s1">&#39;-&#39;</span><span class="p">,</span><span class="s1">&#39; &#39;</span><span class="p">,</span><span class="s1">&#39;.&#39;</span><span class="p">,</span><span class="s1">&#39;&quot;&#39;</span><span class="p">,</span><span class="s1">&#39;=&#39;</span><span class="p">,</span><span class="s1">&#39;#&#39;</span><span class="p">],</span></div><div class='line' id='LC29'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;background-image&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;image&#39;</span><span class="p">],</span></div><div class='line' id='LC30'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;background-color&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;color&#39;</span><span class="p">],</span></div><div class='line' id='LC31'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;border-color&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;color&#39;</span><span class="p">],</span></div><div class='line' id='LC32'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;border-image&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;image&#39;</span><span class="p">],</span></div><div class='line' id='LC33'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;color&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;color&#39;</span><span class="p">],</span></div><div class='line' id='LC34'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;icon&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;image&#39;</span><span class="p">],</span></div><div class='line' id='LC35'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;list-style-image&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;image&#39;</span><span class="p">],</span></div><div class='line' id='LC36'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;outline-color&#39;</span><span class="o">:</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;color&#39;</span><span class="p">]</span></div><div class='line' id='LC37'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC38'><br/></div><div class='line' id='LC39'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// In addition to whitelist filtering for proper encoding - there are some things that should just simply be</span></div><div class='line' id='LC40'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// considered to be unsafe. Setting javascript events or style properties with the encodeHTMLAttribute method and</span></div><div class='line' id='LC41'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// using javascript: urls should be looked at as bad form all the way around and should be avoided. The blacklisting</span></div><div class='line' id='LC42'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// feature of the plugin can be disabled by calling $.encoder.disableBlacklist() prior to the first call encoding</span></div><div class='line' id='LC43'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// takes place (ES5 Compatibility Only)</span></div><div class='line' id='LC44'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">unsafeKeys</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC45'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Style and JS Event attributes should be set through the appropriate methods encodeForCSS, encodeForURL, or</span></div><div class='line' id='LC46'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// encodeForJavascript</span></div><div class='line' id='LC47'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;attr_name&#39;</span> <span class="o">:</span> <span class="p">[</span><span class="s1">&#39;on[a-z]{1,}&#39;</span><span class="p">,</span> <span class="s1">&#39;style&#39;</span><span class="p">,</span> <span class="s1">&#39;href&#39;</span><span class="p">,</span> <span class="s1">&#39;src&#39;</span><span class="p">],</span></div><div class='line' id='LC48'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Allowing Javascript url&#39;s in untrusted data is a bad idea.</span></div><div class='line' id='LC49'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;attr_val&#39;</span>  <span class="o">:</span> <span class="p">[</span><span class="s1">&#39;javascript:&#39;</span><span class="p">],</span></div><div class='line' id='LC50'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// These css keys and values are considered to be unsafe to pass in untrusted data into.</span></div><div class='line' id='LC51'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;css_key&#39;</span>   <span class="o">:</span> <span class="p">[</span><span class="s1">&#39;behavior&#39;</span><span class="p">,</span> <span class="s1">&#39;-moz-behavior&#39;</span><span class="p">,</span> <span class="s1">&#39;-ms-behavior&#39;</span><span class="p">],</span></div><div class='line' id='LC52'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;css_val&#39;</span>   <span class="o">:</span> <span class="p">[</span><span class="s1">&#39;expression&#39;</span><span class="p">]</span></div><div class='line' id='LC53'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC54'><br/></div><div class='line' id='LC55'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">options</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC56'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">blacklist</span><span class="o">:</span> <span class="kc">true</span></div><div class='line' id='LC57'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC58'><br/></div><div class='line' id='LC59'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC60'><br/></div><div class='line' id='LC61'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC62'><span class="cm">     * Encoder is the static container for the encodeFor* series and canonicalize methods. They are contained within</span></div><div class='line' id='LC63'><span class="cm">     * the encoder object so the plugin can take advantage of object freezing provided in ES5 to protect these methods</span></div><div class='line' id='LC64'><span class="cm">     * from being tampered with at runtime.</span></div><div class='line' id='LC65'><span class="cm">     */</span></div><div class='line' id='LC66'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC67'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">author</span><span class="o">:</span> <span class="s1">&#39;Chris Schmidt (chris.schmidt@owasp.org)&#39;</span><span class="p">,</span></div><div class='line' id='LC68'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">version</span><span class="o">:</span> <span class="s1">&#39;${project.version}&#39;</span><span class="p">,</span></div><div class='line' id='LC69'><br/></div><div class='line' id='LC70'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC71'><span class="cm">         * Allows configuration of runtime options prior to using the plugin. Once the plugin has been initialized,</span></div><div class='line' id='LC72'><span class="cm">         * options cannot be changed.</span></div><div class='line' id='LC73'><span class="cm">         *</span></div><div class='line' id='LC74'><span class="cm">         * Possible Options:</span></div><div class='line' id='LC75'><span class="cm">         * &lt;pre&gt;</span></div><div class='line' id='LC76'><span class="cm">         * Options              Description                         Default</span></div><div class='line' id='LC77'><span class="cm">         * ----------------------------------------------------------------------------</span></div><div class='line' id='LC78'><span class="cm">         * blacklist            Enable blacklist validation         true</span></div><div class='line' id='LC79'><span class="cm">         * &lt;/pre&gt;</span></div><div class='line' id='LC80'><span class="cm">         *</span></div><div class='line' id='LC81'><span class="cm">         * @param opts</span></div><div class='line' id='LC82'><span class="cm">         */</span></div><div class='line' id='LC83'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">init</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">opts</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC84'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">hasBeenInitialized</span> <span class="p">)</span></div><div class='line' id='LC85'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;jQuery Encoder has already been initialized - cannot set options after initialization&quot;</span><span class="p">;</span></div><div class='line' id='LC86'><br/></div><div class='line' id='LC87'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC88'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">extend</span><span class="p">(</span> <span class="nx">options</span><span class="p">,</span> <span class="nx">opts</span> <span class="p">);</span></div><div class='line' id='LC89'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC90'><br/></div><div class='line' id='LC91'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC92'><span class="cm">         * Encodes the provided input in a manner safe to place between to HTML tags</span></div><div class='line' id='LC93'><span class="cm">         * @param input The untrusted input to be encoded</span></div><div class='line' id='LC94'><span class="cm">         */</span></div><div class='line' id='LC95'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encodeForHTML</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC96'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC97'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">div</span> <span class="o">=</span> <span class="nb">document</span><span class="p">.</span><span class="nx">createElement</span><span class="p">(</span><span class="s1">&#39;div&#39;</span><span class="p">);</span></div><div class='line' id='LC98'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">(</span><span class="nx">div</span><span class="p">).</span><span class="nx">text</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC99'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">$</span><span class="p">(</span><span class="nx">div</span><span class="p">).</span><span class="nx">html</span><span class="p">();</span></div><div class='line' id='LC100'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC101'><br/></div><div class='line' id='LC102'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC103'><span class="cm">         * Encodes the provided input in a manner safe to place in the value (between to &quot;&#39;s) in an HTML attribute.</span></div><div class='line' id='LC104'><span class="cm">         *</span></div><div class='line' id='LC105'><span class="cm">         * Unless directed not to, this method will return the full &lt;code&gt;attr=&quot;value&quot;&lt;/code&gt; as a string. If</span></div><div class='line' id='LC106'><span class="cm">         * &lt;code&gt;omitAttributeName&lt;/code&gt; is true, the method will only return the &lt;code&gt;value&lt;/code&gt;. Both the attribute</span></div><div class='line' id='LC107'><span class="cm">         * name and value are canonicalized and verified with whitelist and blacklist prior to returning.</span></div><div class='line' id='LC108'><span class="cm">         *</span></div><div class='line' id='LC109'><span class="cm">         * Example:</span></div><div class='line' id='LC110'><span class="cm">         * &lt;pre&gt;</span></div><div class='line' id='LC111'><span class="cm">         * $(&#39;#container&#39;).html(&#39;&amp;lt;div &#39; + $.encoder.encodeForHTMLAttribute(&#39;class&#39;, untrustedData) + &#39;/&gt;&#39;);</span></div><div class='line' id='LC112'><span class="cm">         * &lt;/pre&gt;</span></div><div class='line' id='LC113'><span class="cm">         *</span></div><div class='line' id='LC114'><span class="cm">         * @param attr The attribute to encode for</span></div><div class='line' id='LC115'><span class="cm">         * @param input The untrusted input to be encoded</span></div><div class='line' id='LC116'><span class="cm">         * @param omitAttributeName Whether to omit the attribute name and the enclosing quotes or not from the encoded</span></div><div class='line' id='LC117'><span class="cm">         *                          output.</span></div><div class='line' id='LC118'><span class="cm">         * @throws String Reports error when an unsafe attribute name or value is used (unencoded)</span></div><div class='line' id='LC119'><span class="cm">         * @throws String Reports error when attribute name contains invalid characters (unencoded)</span></div><div class='line' id='LC120'><span class="cm">         */</span></div><div class='line' id='LC121'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encodeForHTMLAttribute</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">attr</span><span class="p">,</span><span class="nx">input</span><span class="p">,</span><span class="nx">omitAttributeName</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC122'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC123'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Check for unsafe attributes</span></div><div class='line' id='LC124'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">attr</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">canonicalize</span><span class="p">(</span><span class="nx">attr</span><span class="p">).</span><span class="nx">toLowerCase</span><span class="p">();</span></div><div class='line' id='LC125'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">canonicalize</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC126'><br/></div><div class='line' id='LC127'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">$</span><span class="p">.</span><span class="nx">inArray</span><span class="p">(</span><span class="nx">attr</span><span class="p">,</span> <span class="nx">unsafeKeys</span><span class="p">[</span><span class="s1">&#39;attr_name&#39;</span><span class="p">])</span> <span class="o">&gt;=</span> <span class="mi">0</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC128'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Unsafe attribute name used: &quot;</span> <span class="o">+</span> <span class="nx">attr</span><span class="p">;</span></div><div class='line' id='LC129'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC130'><br/></div><div class='line' id='LC131'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span> <span class="kd">var</span> <span class="nx">a</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span> <span class="nx">a</span> <span class="o">&lt;</span> <span class="nx">unsafeKeys</span><span class="p">[</span><span class="s1">&#39;attr_val&#39;</span><span class="p">];</span> <span class="nx">a</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC132'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">input</span><span class="p">.</span><span class="nx">toLowerCase</span><span class="p">().</span><span class="nx">match</span><span class="p">(</span><span class="nx">unsafeKeys</span><span class="p">[</span><span class="s1">&#39;attr_val&#39;</span><span class="p">][</span><span class="nx">a</span><span class="p">])</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC133'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Unsafe attribute value used: &quot;</span> <span class="o">+</span> <span class="nx">input</span><span class="p">;</span></div><div class='line' id='LC134'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC135'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC136'><br/></div><div class='line' id='LC137'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">immune</span> <span class="o">=</span> <span class="nx">attr_whitelist</span><span class="p">[</span><span class="nx">attr</span><span class="p">];</span></div><div class='line' id='LC138'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// If no whitelist exists for the attribute, use the minimal default whitelist</span></div><div class='line' id='LC139'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">immune</span> <span class="p">)</span> <span class="nx">immune</span> <span class="o">=</span> <span class="nx">attr_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;default&#39;</span><span class="p">];</span></div><div class='line' id='LC140'><br/></div><div class='line' id='LC141'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">encoded</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC142'><br/></div><div class='line' id='LC143'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">omitAttributeName</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC144'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">p</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">p</span> <span class="o">&lt;</span> <span class="nx">attr</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">p</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC145'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">pc</span> <span class="o">=</span> <span class="nx">attr</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">p</span><span class="p">);</span></div><div class='line' id='LC146'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">pc</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/[a-zA-Z\-0-9]/</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC147'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Invalid attribute name specified&quot;</span><span class="p">;</span></div><div class='line' id='LC148'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC149'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nx">pc</span><span class="p">;</span></div><div class='line' id='LC150'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC151'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;=&quot;&#39;</span><span class="p">;</span></div><div class='line' id='LC152'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC153'><br/></div><div class='line' id='LC154'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">input</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC155'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">ch</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">i</span><span class="p">),</span> <span class="nx">cc</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">charCodeAt</span><span class="p">(</span><span class="nx">i</span><span class="p">);</span></div><div class='line' id='LC156'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">ch</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/[a-zA-Z0-9]/</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">$</span><span class="p">.</span><span class="nx">inArray</span><span class="p">(</span><span class="nx">ch</span><span class="p">,</span> <span class="nx">immune</span><span class="p">)</span> <span class="o">&lt;</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC157'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">hex</span> <span class="o">=</span> <span class="nx">cc</span><span class="p">.</span><span class="nx">toString</span><span class="p">(</span><span class="mi">16</span><span class="p">);</span></div><div class='line' id='LC158'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;&amp;#x&#39;</span> <span class="o">+</span> <span class="nx">hex</span> <span class="o">+</span> <span class="s1">&#39;;&#39;</span><span class="p">;</span></div><div class='line' id='LC159'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC160'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nx">ch</span><span class="p">;</span></div><div class='line' id='LC161'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC162'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC163'><br/></div><div class='line' id='LC164'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">omitAttributeName</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC165'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;&quot;&#39;</span><span class="p">;</span></div><div class='line' id='LC166'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC167'><br/></div><div class='line' id='LC168'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">encoded</span><span class="p">;</span></div><div class='line' id='LC169'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC170'><br/></div><div class='line' id='LC171'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC172'><span class="cm">         * Encodes the provided input in a manner safe to place in the value of an elements &lt;code&gt;style&lt;/code&gt; attribute</span></div><div class='line' id='LC173'><span class="cm">         *</span></div><div class='line' id='LC174'><span class="cm">         * Unless directed not to, this method will return the full &lt;code&gt;property: value&lt;/code&gt; as a string. If</span></div><div class='line' id='LC175'><span class="cm">         * &lt;code&gt;omitPropertyName&lt;/code&gt; is &lt;code&gt;true&lt;/code&gt;, the method will only return the &lt;code&gt;value&lt;/code&gt;. Both</span></div><div class='line' id='LC176'><span class="cm">         * the property name and value are canonicalized and verified with whitelist and blacklist prior to returning.</span></div><div class='line' id='LC177'><span class="cm">         *</span></div><div class='line' id='LC178'><span class="cm">         * Example:</span></div><div class='line' id='LC179'><span class="cm">         * &lt;pre&gt;</span></div><div class='line' id='LC180'><span class="cm">         * $(&#39;#container&#39;).html(&#39;&amp;lt;div style=&quot;&#39; + $.encoder.encodeForCSS(&#39;background-image&#39;, untrustedData) + &#39;&quot;/&gt;&#39;);</span></div><div class='line' id='LC181'><span class="cm">         * &lt;/pre&gt;</span></div><div class='line' id='LC182'><span class="cm">         *</span></div><div class='line' id='LC183'><span class="cm">         * @param propName The property name that is being set</span></div><div class='line' id='LC184'><span class="cm">         * @param input The untrusted input to be encoded</span></div><div class='line' id='LC185'><span class="cm">         * @param omitPropertyName Whether to omit the property name from the encoded output</span></div><div class='line' id='LC186'><span class="cm">         *</span></div><div class='line' id='LC187'><span class="cm">         * @throws String Reports error when an unsafe property name or value is used</span></div><div class='line' id='LC188'><span class="cm">         * @throws String Reports error when illegal characters passed in property name</span></div><div class='line' id='LC189'><span class="cm">         */</span></div><div class='line' id='LC190'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encodeForCSS</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">propName</span><span class="p">,</span><span class="nx">input</span><span class="p">,</span><span class="nx">omitPropertyName</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC191'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC192'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Check for unsafe properties</span></div><div class='line' id='LC193'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">propName</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">canonicalize</span><span class="p">(</span><span class="nx">propName</span><span class="p">).</span><span class="nx">toLowerCase</span><span class="p">();</span></div><div class='line' id='LC194'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">canonicalize</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC195'><br/></div><div class='line' id='LC196'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">$</span><span class="p">.</span><span class="nx">inArray</span><span class="p">(</span><span class="nx">propName</span><span class="p">,</span> <span class="nx">unsafeKeys</span><span class="p">[</span><span class="s1">&#39;css_key&#39;</span><span class="p">]</span> <span class="p">)</span> <span class="o">&gt;=</span> <span class="mi">0</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC197'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Unsafe property name used: &quot;</span> <span class="o">+</span> <span class="nx">propName</span><span class="p">;</span></div><div class='line' id='LC198'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC199'><br/></div><div class='line' id='LC200'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span> <span class="kd">var</span> <span class="nx">a</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span> <span class="nx">a</span> <span class="o">&lt;</span> <span class="nx">unsafeKeys</span><span class="p">[</span><span class="s1">&#39;css_val&#39;</span><span class="p">].</span><span class="nx">length</span><span class="p">;</span> <span class="nx">a</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC201'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">input</span><span class="p">.</span><span class="nx">toLowerCase</span><span class="p">().</span><span class="nx">indexOf</span><span class="p">(</span><span class="nx">unsafeKeys</span><span class="p">[</span><span class="s1">&#39;css_val&#39;</span><span class="p">][</span><span class="nx">a</span><span class="p">])</span> <span class="o">&gt;=</span> <span class="mi">0</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC202'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Unsafe property value used: &quot;</span> <span class="o">+</span> <span class="nx">input</span><span class="p">;</span></div><div class='line' id='LC203'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC204'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC205'><br/></div><div class='line' id='LC206'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">immune</span> <span class="o">=</span> <span class="nx">css_whitelist</span><span class="p">[</span><span class="nx">propName</span><span class="p">];</span></div><div class='line' id='LC207'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// If no whitelist exists for that property, use the minimal default whitelist</span></div><div class='line' id='LC208'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">immune</span> <span class="p">)</span> <span class="nx">immune</span> <span class="o">=</span> <span class="nx">css_whitelist_classes</span><span class="p">[</span><span class="s1">&#39;default&#39;</span><span class="p">];</span></div><div class='line' id='LC209'><br/></div><div class='line' id='LC210'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">encoded</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC211'><br/></div><div class='line' id='LC212'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">omitPropertyName</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC213'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">p</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">p</span> <span class="o">&lt;</span> <span class="nx">propName</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">p</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC214'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">pc</span> <span class="o">=</span> <span class="nx">propName</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">p</span><span class="p">);</span></div><div class='line' id='LC215'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">pc</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/[a-zA-Z\-]/</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC216'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Invalid Property Name specified&quot;</span><span class="p">;</span></div><div class='line' id='LC217'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC218'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nx">pc</span><span class="p">;</span></div><div class='line' id='LC219'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC220'><br/></div><div class='line' id='LC221'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;: &#39;</span><span class="p">;</span></div><div class='line' id='LC222'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC223'><br/></div><div class='line' id='LC224'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">input</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC225'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">ch</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">i</span><span class="p">),</span> <span class="nx">cc</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">charCodeAt</span><span class="p">(</span><span class="nx">i</span><span class="p">);</span></div><div class='line' id='LC226'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="o">!</span><span class="nx">ch</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/[a-zA-Z0-9]/</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">$</span><span class="p">.</span><span class="nx">inArray</span><span class="p">(</span><span class="nx">ch</span><span class="p">,</span> <span class="nx">immune</span><span class="p">)</span> <span class="o">&lt;</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC227'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">hex</span> <span class="o">=</span> <span class="nx">cc</span><span class="p">.</span><span class="nx">toString</span><span class="p">(</span><span class="mi">16</span><span class="p">);</span></div><div class='line' id='LC228'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">pad</span> <span class="o">=</span> <span class="s1">&#39;000000&#39;</span><span class="p">.</span><span class="nx">substr</span><span class="p">((</span><span class="nx">hex</span><span class="p">.</span><span class="nx">length</span><span class="p">));</span></div><div class='line' id='LC229'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;\\&#39;</span> <span class="o">+</span> <span class="nx">pad</span> <span class="o">+</span> <span class="nx">hex</span><span class="p">;</span></div><div class='line' id='LC230'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC231'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nx">ch</span><span class="p">;</span></div><div class='line' id='LC232'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC233'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC234'><br/></div><div class='line' id='LC235'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">encoded</span><span class="p">;</span></div><div class='line' id='LC236'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC237'><br/></div><div class='line' id='LC238'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC239'><span class="cm">         * Encodes the provided input in a manner safe to place in the value of a POST or GET parameter on a request. This</span></div><div class='line' id='LC240'><span class="cm">         * is primarily used to mitigate parameter-splitting attacks and ensure that parameter values are within specification</span></div><div class='line' id='LC241'><span class="cm">         *</span></div><div class='line' id='LC242'><span class="cm">         * @param input The untrusted data to be encoded</span></div><div class='line' id='LC243'><span class="cm">         * @param attr (optional) If passed in, the method will return the full string &lt;code&gt;attr=&quot;value&quot;&lt;/code&gt; where</span></div><div class='line' id='LC244'><span class="cm">         *             the value will be encoded for a URL and both the attribute and value will be canonicalized prior</span></div><div class='line' id='LC245'><span class="cm">         *             to encoding the value.</span></div><div class='line' id='LC246'><span class="cm">         */</span></div><div class='line' id='LC247'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encodeForURL</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">,</span><span class="nx">attr</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC248'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC249'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">encoded</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC250'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">attr</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC251'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">attr</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/^[A-Za-z\-0-9]{1,}$/</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC252'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">canonicalize</span><span class="p">(</span><span class="nx">attr</span><span class="p">).</span><span class="nx">toLowerCase</span><span class="p">();</span></div><div class='line' id='LC253'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC254'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Illegal Attribute Name Specified&quot;</span><span class="p">;</span></div><div class='line' id='LC255'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC256'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;=&quot;&#39;</span><span class="p">;</span></div><div class='line' id='LC257'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC258'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nb">encodeURIComponent</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC259'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nx">attr</span> <span class="o">?</span> <span class="s1">&#39;&quot;&#39;</span> <span class="o">:</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC260'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">encoded</span><span class="p">;</span></div><div class='line' id='LC261'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC262'><br/></div><div class='line' id='LC263'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC264'><span class="cm">         * Encodes the provided input in a manner safe to place in a javascript context, such as the value of an entity</span></div><div class='line' id='LC265'><span class="cm">         * event like onmouseover. This encoding is slightly different than just encoding for an html attribute value as</span></div><div class='line' id='LC266'><span class="cm">         * it follows the escaping rules of javascript. Use this method when dynamically writing out html to an element</span></div><div class='line' id='LC267'><span class="cm">         * as opposed to building an element up using the DOM - as with the .html() method.</span></div><div class='line' id='LC268'><span class="cm">         *</span></div><div class='line' id='LC269'><span class="cm">         * Example $(&#39;#element&#39;).html(&#39;&amp;lt;a onclick=somefunction(\&#39;&quot;&#39; + $.encodeForJavascript($(&#39;#input&#39;).val()) + &#39;\&#39;);&quot;&gt;Blargh&amp;lt;/a&gt;&#39;);</span></div><div class='line' id='LC270'><span class="cm">         *</span></div><div class='line' id='LC271'><span class="cm">         * @param input The untrusted input to be encoded</span></div><div class='line' id='LC272'><span class="cm">         */</span></div><div class='line' id='LC273'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encodeForJavascript</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC274'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC275'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nx">immune</span> <span class="p">)</span> <span class="nx">immune</span> <span class="o">=</span> <span class="nx">default_immune</span><span class="p">[</span><span class="s1">&#39;js&#39;</span><span class="p">];</span></div><div class='line' id='LC276'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">encoded</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC277'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">input</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC278'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">ch</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">i</span><span class="p">),</span> <span class="nx">cc</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">charCodeAt</span><span class="p">(</span><span class="nx">i</span><span class="p">);</span></div><div class='line' id='LC279'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">inArray</span><span class="p">(</span><span class="nx">ch</span><span class="p">,</span> <span class="nx">immune</span><span class="p">)</span> <span class="o">&gt;=</span> <span class="mi">0</span> <span class="o">||</span> <span class="nx">hex</span><span class="p">[</span><span class="nx">cc</span><span class="p">]</span> <span class="o">==</span> <span class="kc">null</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC280'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="nx">ch</span><span class="p">;</span></div><div class='line' id='LC281'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">continue</span><span class="p">;</span></div><div class='line' id='LC282'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC283'><br/></div><div class='line' id='LC284'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">temp</span> <span class="o">=</span> <span class="nx">cc</span><span class="p">.</span><span class="nx">toString</span><span class="p">(</span><span class="mi">16</span><span class="p">),</span> <span class="nx">pad</span><span class="p">;</span></div><div class='line' id='LC285'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">cc</span> <span class="o">&lt;</span> <span class="mi">256</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC286'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">pad</span> <span class="o">=</span> <span class="s1">&#39;00&#39;</span><span class="p">.</span><span class="nx">substr</span><span class="p">(</span><span class="nx">temp</span><span class="p">.</span><span class="nx">length</span><span class="p">);</span></div><div class='line' id='LC287'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;\\x&#39;</span> <span class="o">+</span> <span class="nx">pad</span> <span class="o">+</span> <span class="nx">temp</span><span class="p">.</span><span class="nx">toUpperCase</span><span class="p">();</span></div><div class='line' id='LC288'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC289'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">pad</span> <span class="o">=</span> <span class="s1">&#39;0000&#39;</span><span class="p">.</span><span class="nx">substr</span><span class="p">(</span><span class="nx">temp</span><span class="p">.</span><span class="nx">length</span><span class="p">);</span></div><div class='line' id='LC290'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">encoded</span> <span class="o">+=</span> <span class="s1">&#39;\\u&#39;</span> <span class="o">+</span> <span class="nx">pad</span> <span class="o">+</span> <span class="nx">temp</span><span class="p">.</span><span class="nx">toUpperCase</span><span class="p">();</span></div><div class='line' id='LC291'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC292'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC293'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">encoded</span><span class="p">;</span></div><div class='line' id='LC294'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC295'><br/></div><div class='line' id='LC296'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">canonicalize</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">,</span><span class="nx">strict</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC297'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC298'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">input</span><span class="o">===</span><span class="kc">null</span><span class="p">)</span> <span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC299'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="nx">input</span><span class="p">,</span> <span class="nx">cycle_out</span> <span class="o">=</span> <span class="nx">input</span><span class="p">;</span></div><div class='line' id='LC300'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">decodeCount</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="nx">cycles</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span></div><div class='line' id='LC301'><br/></div><div class='line' id='LC302'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">codecs</span> <span class="o">=</span>  <span class="p">[</span> <span class="k">new</span> <span class="nx">HTMLEntityCodec</span><span class="p">(),</span> <span class="k">new</span> <span class="nx">PercentCodec</span><span class="p">(),</span> <span class="k">new</span> <span class="nx">CSSCodec</span><span class="p">()</span> <span class="p">];</span></div><div class='line' id='LC303'><br/></div><div class='line' id='LC304'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">while</span> <span class="p">(</span><span class="kc">true</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC305'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">cycle_out</span> <span class="o">=</span> <span class="nx">out</span><span class="p">;</span></div><div class='line' id='LC306'><br/></div><div class='line' id='LC307'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">codecs</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC308'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">new_out</span> <span class="o">=</span> <span class="nx">codecs</span><span class="p">[</span><span class="nx">i</span><span class="p">].</span><span class="nx">decode</span><span class="p">(</span><span class="nx">out</span><span class="p">);</span></div><div class='line' id='LC309'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">new_out</span> <span class="o">!=</span> <span class="nx">out</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC310'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">decodeCount</span><span class="o">++</span><span class="p">;</span></div><div class='line' id='LC311'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span> <span class="o">=</span> <span class="nx">new_out</span><span class="p">;</span></div><div class='line' id='LC312'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC313'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC314'><br/></div><div class='line' id='LC315'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">cycle_out</span> <span class="o">==</span> <span class="nx">out</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC316'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC317'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC318'><br/></div><div class='line' id='LC319'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">cycles</span><span class="o">++</span><span class="p">;</span></div><div class='line' id='LC320'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC321'><br/></div><div class='line' id='LC322'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">strict</span> <span class="o">&amp;&amp;</span> <span class="nx">decodeCount</span> <span class="o">&gt;</span> <span class="mi">1</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC323'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">throw</span> <span class="s2">&quot;Attack Detected - Multiple/Double Encodings used in input&quot;</span><span class="p">;</span></div><div class='line' id='LC324'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC325'><br/></div><div class='line' id='LC326'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">out</span><span class="p">;</span></div><div class='line' id='LC327'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC328'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC329'><br/></div><div class='line' id='LC330'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">hex</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC331'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span> <span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">c</span> <span class="o">&lt;</span> <span class="mh">0xFF</span><span class="p">;</span> <span class="nx">c</span><span class="o">++</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC332'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">c</span> <span class="o">&gt;=</span> <span class="mh">0x30</span> <span class="o">&amp;&amp;</span> <span class="nx">c</span> <span class="o">&lt;=</span> <span class="mh">0x39</span> <span class="o">||</span> <span class="nx">c</span> <span class="o">&gt;=</span> <span class="mh">0x41</span> <span class="o">&amp;&amp;</span> <span class="nx">c</span> <span class="o">&lt;=</span> <span class="mh">0x5a</span> <span class="o">||</span> <span class="nx">c</span> <span class="o">&gt;=</span> <span class="mh">0x61</span> <span class="o">&amp;&amp;</span> <span class="nx">c</span> <span class="o">&lt;=</span> <span class="mh">0x7a</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC333'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hex</span><span class="p">[</span><span class="nx">c</span><span class="p">]</span> <span class="o">=</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC334'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC335'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hex</span><span class="p">[</span><span class="nx">c</span><span class="p">]</span> <span class="o">=</span> <span class="nx">c</span><span class="p">.</span><span class="nx">toString</span><span class="p">(</span><span class="mi">16</span><span class="p">);</span></div><div class='line' id='LC336'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC337'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC338'><br/></div><div class='line' id='LC339'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">methods</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC340'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">html</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">opts</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC341'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">encodeForHTML</span><span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">unsafe</span><span class="p">);</span></div><div class='line' id='LC342'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC343'><br/></div><div class='line' id='LC344'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">css</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">opts</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC345'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">work</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC346'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC347'><br/></div><div class='line' id='LC348'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">map</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC349'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">work</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">map</span><span class="p">;</span></div><div class='line' id='LC350'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC351'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">work</span><span class="p">[</span><span class="nx">opts</span><span class="p">.</span><span class="nx">name</span><span class="p">]</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">unsafe</span><span class="p">;</span></div><div class='line' id='LC352'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC353'><br/></div><div class='line' id='LC354'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">k</span> <span class="k">in</span> <span class="nx">work</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC355'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="p">(</span><span class="k">typeof</span> <span class="nx">work</span><span class="p">[</span><span class="nx">k</span><span class="p">]</span> <span class="o">==</span> <span class="s1">&#39;function&#39;</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">work</span><span class="p">.</span><span class="nx">hasOwnProperty</span><span class="p">(</span><span class="nx">k</span><span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC356'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span><span class="p">[</span><span class="nx">k</span><span class="p">]</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">encodeForCSS</span><span class="p">(</span><span class="nx">k</span><span class="p">,</span> <span class="nx">work</span><span class="p">[</span><span class="nx">k</span><span class="p">],</span> <span class="kc">true</span><span class="p">);</span></div><div class='line' id='LC357'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC358'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC359'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">out</span><span class="p">;</span></div><div class='line' id='LC360'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC361'><br/></div><div class='line' id='LC362'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">attr</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">opts</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC363'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">work</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC364'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC365'><br/></div><div class='line' id='LC366'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">map</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC367'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">work</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">map</span><span class="p">;</span></div><div class='line' id='LC368'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC369'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">work</span><span class="p">[</span><span class="nx">opts</span><span class="p">.</span><span class="nx">name</span><span class="p">]</span> <span class="o">=</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">unsafe</span><span class="p">;</span></div><div class='line' id='LC370'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC371'><br/></div><div class='line' id='LC372'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">k</span> <span class="k">in</span> <span class="nx">work</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC373'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">work</span><span class="p">[</span><span class="nx">k</span><span class="p">]</span> <span class="o">==</span> <span class="s1">&#39;function&#39;</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">work</span><span class="p">.</span><span class="nx">hasOwnProperty</span><span class="p">(</span><span class="nx">k</span><span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC374'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span><span class="p">[</span><span class="nx">k</span><span class="p">]</span> <span class="o">=</span> <span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">.</span><span class="nx">encodeForHTMLAttribute</span><span class="p">(</span><span class="nx">k</span><span class="p">,</span><span class="nx">work</span><span class="p">[</span><span class="nx">k</span><span class="p">],</span><span class="kc">true</span><span class="p">);</span></div><div class='line' id='LC375'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC376'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC377'><br/></div><div class='line' id='LC378'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">out</span><span class="p">;</span></div><div class='line' id='LC379'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC380'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC381'><br/></div><div class='line' id='LC382'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC383'><span class="cm">     * Use this instead of setting the content of an element manually with untrusted user supplied data. The context can</span></div><div class='line' id='LC384'><span class="cm">     * be one of &#39;html&#39;, &#39;css&#39;, or &#39;attr&#39;</span></div><div class='line' id='LC385'><span class="cm">     */</span></div><div class='line' id='LC386'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">encode</span> <span class="o">=</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC387'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBeenInitialized</span> <span class="o">=</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC388'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">argCount</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span></div><div class='line' id='LC389'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">opts</span> <span class="o">=</span> <span class="p">{</span></div><div class='line' id='LC390'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;context&#39;</span>   <span class="o">:</span> <span class="s1">&#39;html&#39;</span><span class="p">,</span></div><div class='line' id='LC391'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;unsafe&#39;</span>    <span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC392'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;name&#39;</span>      <span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC393'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;map&#39;</span>       <span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC394'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;setter&#39;</span>    <span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC395'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;strict&#39;</span>    <span class="o">:</span> <span class="kc">true</span></div><div class='line' id='LC396'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC397'><br/></div><div class='line' id='LC398'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">argCount</span> <span class="o">==</span> <span class="mi">1</span> <span class="o">&amp;&amp;</span> <span class="k">typeof</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="o">==</span> <span class="s1">&#39;object&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC399'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">extend</span><span class="p">(</span><span class="nx">opts</span><span class="p">,</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">0</span><span class="p">]);</span></div><div class='line' id='LC400'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC401'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">context</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">0</span><span class="p">];</span></div><div class='line' id='LC402'><br/></div><div class='line' id='LC403'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">arguments</span><span class="p">.</span><span class="nx">length</span> <span class="o">==</span> <span class="mi">2</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC404'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">context</span> <span class="o">==</span> <span class="s1">&#39;html&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC405'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">unsafe</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">1</span><span class="p">];</span></div><div class='line' id='LC406'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC407'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">content</span> <span class="o">==</span> <span class="s1">&#39;attr&#39;</span> <span class="o">||</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">content</span> <span class="o">==</span> <span class="s1">&#39;css&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC408'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">map</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">1</span><span class="p">];</span></div><div class='line' id='LC409'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC410'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC411'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">name</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">1</span><span class="p">];</span></div><div class='line' id='LC412'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">unsafe</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">2</span><span class="p">];</span></div><div class='line' id='LC413'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC414'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC415'><br/></div><div class='line' id='LC416'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">context</span> <span class="o">==</span> <span class="s1">&#39;html&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC417'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">setter</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">html</span><span class="p">;</span></div><div class='line' id='LC418'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC419'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">context</span> <span class="o">==</span> <span class="s1">&#39;css&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC420'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">setter</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">css</span><span class="p">;</span></div><div class='line' id='LC421'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC422'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">opts</span><span class="p">.</span><span class="nx">context</span> <span class="o">==</span> <span class="s1">&#39;attr&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC423'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">opts</span><span class="p">.</span><span class="nx">setter</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">attr</span><span class="p">;</span></div><div class='line' id='LC424'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC425'><br/></div><div class='line' id='LC426'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">opts</span><span class="p">.</span><span class="nx">setter</span><span class="p">.</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">methods</span><span class="p">[</span><span class="nx">opts</span><span class="p">.</span><span class="nx">context</span><span class="p">].</span><span class="nx">call</span><span class="p">(</span><span class="k">this</span><span class="p">,</span> <span class="nx">opts</span><span class="p">));</span></div><div class='line' id='LC427'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC428'><br/></div><div class='line' id='LC429'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC430'><span class="cm">     * The pushback string is used by Codecs to allow them to push decoded characters back onto a string for further</span></div><div class='line' id='LC431'><span class="cm">     * decoding. This is necessary to detect double-encoding.</span></div><div class='line' id='LC432'><span class="cm">     */</span></div><div class='line' id='LC433'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">PushbackString</span> <span class="o">=</span> <span class="nx">Class</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC434'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_input</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC435'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_pushback</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC436'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_temp</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC437'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_index</span><span class="o">:</span> <span class="mi">0</span><span class="p">,</span></div><div class='line' id='LC438'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_mark</span><span class="o">:</span> <span class="mi">0</span><span class="p">,</span></div><div class='line' id='LC439'><br/></div><div class='line' id='LC440'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_hasNext</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC441'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_input</span> <span class="o">==</span> <span class="kc">null</span> <span class="p">)</span> <span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC442'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_input</span><span class="p">.</span><span class="nx">length</span> <span class="o">==</span> <span class="mi">0</span> <span class="p">)</span> <span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC443'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_index</span> <span class="o">&lt;</span> <span class="k">this</span><span class="p">.</span><span class="nx">_input</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span></div><div class='line' id='LC444'><br/></div><div class='line' id='LC445'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC446'><br/></div><div class='line' id='LC447'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">init</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC448'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_input</span> <span class="o">=</span> <span class="nx">input</span><span class="p">;</span></div><div class='line' id='LC449'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC450'><br/></div><div class='line' id='LC451'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">pushback</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">c</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC452'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">=</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC453'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC454'><br/></div><div class='line' id='LC455'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">index</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC456'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_index</span><span class="p">;</span></div><div class='line' id='LC457'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC458'><br/></div><div class='line' id='LC459'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasNext</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC460'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">!=</span> <span class="kc">null</span> <span class="p">)</span> <span class="k">return</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC461'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_hasNext</span><span class="p">();</span></div><div class='line' id='LC462'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC463'><br/></div><div class='line' id='LC464'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">next</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC465'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">!=</span> <span class="kc">null</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC466'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">save</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span><span class="p">;</span></div><div class='line' id='LC467'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">=</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC468'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">save</span><span class="p">;</span></div><div class='line' id='LC469'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC470'><br/></div><div class='line' id='LC471'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_hasNext</span><span class="p">()</span> <span class="p">)</span> <span class="o">?</span> <span class="k">this</span><span class="p">.</span><span class="nx">_input</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_index</span><span class="o">++</span> <span class="p">)</span> <span class="o">:</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC472'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC473'><br/></div><div class='line' id='LC474'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">nextHex</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC475'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC476'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">c</span> <span class="o">==</span> <span class="kc">null</span> <span class="p">)</span> <span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC477'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">c</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/[0-9A-Fa-f]/</span><span class="p">)</span> <span class="p">)</span> <span class="k">return</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC478'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC479'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC480'><br/></div><div class='line' id='LC481'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">peek</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">c</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC482'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">c</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC483'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">&amp;&amp;</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">==</span> <span class="nx">c</span> <span class="p">)</span> <span class="k">return</span> <span class="kc">true</span><span class="p">;</span></div><div class='line' id='LC484'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_hasNext</span><span class="p">()</span> <span class="o">?</span> <span class="k">this</span><span class="p">.</span><span class="nx">_input</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">_index</span><span class="p">)</span> <span class="o">==</span> <span class="nx">c</span> <span class="o">:</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC485'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC486'><br/></div><div class='line' id='LC487'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="p">)</span> <span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span><span class="p">;</span></div><div class='line' id='LC488'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_hasNext</span><span class="p">()</span> <span class="o">?</span> <span class="k">this</span><span class="p">.</span><span class="nx">_input</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">_index</span><span class="p">)</span> <span class="o">:</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC489'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC490'><br/></div><div class='line' id='LC491'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">mark</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC492'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_temp</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span><span class="p">;</span></div><div class='line' id='LC493'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_mark</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_index</span><span class="p">;</span></div><div class='line' id='LC494'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC495'><br/></div><div class='line' id='LC496'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">reset</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC497'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_temp</span><span class="p">;</span></div><div class='line' id='LC498'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_index</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_mark</span><span class="p">;</span></div><div class='line' id='LC499'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC500'><br/></div><div class='line' id='LC501'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">remainder</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC502'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_input</span><span class="p">.</span><span class="nx">substr</span><span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_index</span> <span class="p">);</span></div><div class='line' id='LC503'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">!=</span> <span class="kc">null</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC504'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_pushback</span> <span class="o">+</span> <span class="nx">out</span><span class="p">;</span></div><div class='line' id='LC505'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC506'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">out</span><span class="p">;</span></div><div class='line' id='LC507'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC508'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC509'><br/></div><div class='line' id='LC510'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC511'><span class="cm">     * Base class for all codecs to extend. This class defines the default behavior or codecs</span></div><div class='line' id='LC512'><span class="cm">     */</span></div><div class='line' id='LC513'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">Codec</span> <span class="o">=</span> <span class="nx">Class</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC514'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">decode</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC515'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">,</span> <span class="nx">pbs</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">PushbackString</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC516'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">while</span><span class="p">(</span><span class="nx">pbs</span><span class="p">.</span><span class="nx">hasNext</span><span class="p">())</span> <span class="p">{</span></div><div class='line' id='LC517'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">decodeCharacter</span><span class="p">(</span><span class="nx">pbs</span><span class="p">);</span></div><div class='line' id='LC518'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">c</span> <span class="o">!=</span> <span class="kc">null</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC519'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span> <span class="o">+=</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC520'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC521'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span> <span class="o">+=</span> <span class="nx">pbs</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC522'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC523'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC524'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">out</span><span class="p">;</span></div><div class='line' id='LC525'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC526'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/** @Abstract */</span></div><div class='line' id='LC527'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">decodeCharacter</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">pbs</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC528'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">pbs</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC529'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC530'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC531'><br/></div><div class='line' id='LC532'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC533'><span class="cm">     * Codec for decoding HTML Entities in strings. This codec will decode named entities as well as numeric and hex</span></div><div class='line' id='LC534'><span class="cm">     * entities even with padding. For named entities, it interally uses a Trie to locate the &#39;best-match&#39; and speed</span></div><div class='line' id='LC535'><span class="cm">     * up the search.</span></div><div class='line' id='LC536'><span class="cm">     */</span></div><div class='line' id='LC537'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">HTMLEntityCodec</span> <span class="o">=</span> <span class="nx">Codec</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC538'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">decodeCharacter</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC539'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">mark</span><span class="p">();</span></div><div class='line' id='LC540'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">first</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC541'><br/></div><div class='line' id='LC542'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// If there is no input, or this is not an entity - return null</span></div><div class='line' id='LC543'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">first</span> <span class="o">==</span> <span class="kc">null</span> <span class="o">||</span> <span class="nx">first</span> <span class="o">!=</span> <span class="s1">&#39;&amp;&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC544'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC545'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC546'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC547'><br/></div><div class='line' id='LC548'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">second</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC549'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">second</span> <span class="o">==</span> <span class="kc">null</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC550'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC551'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC552'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC553'><br/></div><div class='line' id='LC554'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC555'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">second</span> <span class="o">==</span> <span class="s1">&#39;#&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC556'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">c</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_getNumericEntity</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC557'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">c</span> <span class="o">!=</span> <span class="kc">null</span> <span class="p">)</span> <span class="k">return</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC558'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="nx">second</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/[A-Za-z]/</span><span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC559'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">pushback</span><span class="p">(</span><span class="nx">second</span><span class="p">);</span></div><div class='line' id='LC560'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">c</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_getNamedEntity</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC561'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">c</span> <span class="o">!=</span> <span class="kc">null</span> <span class="p">)</span> <span class="k">return</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC562'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC563'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC564'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC565'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC566'><br/></div><div class='line' id='LC567'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_getNamedEntity</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC568'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">possible</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">,</span> <span class="nx">entry</span><span class="p">,</span> <span class="nx">len</span><span class="p">;</span></div><div class='line' id='LC569'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">len</span> <span class="o">=</span> <span class="nb">Math</span><span class="p">.</span><span class="nx">min</span><span class="p">(</span><span class="nx">input</span><span class="p">.</span><span class="nx">remainder</span><span class="p">().</span><span class="nx">length</span><span class="p">,</span> <span class="nx">ENTITY_TO_CHAR_TRIE</span><span class="p">.</span><span class="nx">getMaxKeyLength</span><span class="p">());</span></div><div class='line' id='LC570'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span><span class="p">(</span><span class="kd">var</span> <span class="nx">i</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span><span class="nx">i</span><span class="o">&lt;</span><span class="nx">len</span><span class="p">;</span><span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC571'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">possible</span> <span class="o">+=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">().</span><span class="nx">toLowerCase</span><span class="p">();</span></div><div class='line' id='LC572'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC573'><br/></div><div class='line' id='LC574'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">entry</span> <span class="o">=</span> <span class="nx">ENTITY_TO_CHAR_TRIE</span><span class="p">.</span><span class="nx">getLongestMatch</span><span class="p">(</span><span class="nx">possible</span><span class="p">);</span></div><div class='line' id='LC575'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">entry</span> <span class="o">==</span> <span class="kc">null</span><span class="p">)</span></div><div class='line' id='LC576'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC577'><br/></div><div class='line' id='LC578'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC579'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC580'><br/></div><div class='line' id='LC581'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">len</span> <span class="o">=</span> <span class="nx">entry</span><span class="p">.</span><span class="nx">getKey</span><span class="p">().</span><span class="nx">length</span><span class="p">;</span></div><div class='line' id='LC582'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span><span class="p">(</span><span class="kd">var</span> <span class="nx">j</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span><span class="nx">j</span><span class="o">&lt;</span><span class="nx">len</span><span class="p">;</span><span class="nx">j</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC583'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC584'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC585'><br/></div><div class='line' id='LC586'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span><span class="p">(</span><span class="nx">input</span><span class="p">.</span><span class="nx">peek</span><span class="p">(</span><span class="s1">&#39;;&#39;</span><span class="p">))</span></div><div class='line' id='LC587'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC588'><br/></div><div class='line' id='LC589'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">entry</span><span class="p">.</span><span class="nx">getValue</span><span class="p">();</span></div><div class='line' id='LC590'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC591'><br/></div><div class='line' id='LC592'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_getNumericEntity</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC593'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">first</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">peek</span><span class="p">();</span></div><div class='line' id='LC594'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">first</span> <span class="o">==</span> <span class="kc">null</span> <span class="p">)</span> <span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC595'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">first</span> <span class="o">==</span> <span class="s1">&#39;x&#39;</span> <span class="o">||</span> <span class="nx">first</span> <span class="o">==</span> <span class="s1">&#39;X&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC596'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC597'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_parseHex</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC598'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC599'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_parseNumber</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC600'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC601'><br/></div><div class='line' id='LC602'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_parseHex</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC603'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC604'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">while</span> <span class="p">(</span><span class="nx">input</span><span class="p">.</span><span class="nx">hasNext</span><span class="p">())</span> <span class="p">{</span></div><div class='line' id='LC605'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">peek</span><span class="p">();</span></div><div class='line' id='LC606'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nb">isNaN</span><span class="p">(</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">c</span><span class="p">,</span> <span class="mi">16</span><span class="p">)</span> <span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC607'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span> <span class="o">+=</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC608'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC609'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="nx">c</span> <span class="o">==</span> <span class="s1">&#39;;&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC610'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC611'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC612'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC613'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC614'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC615'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC616'><br/></div><div class='line' id='LC617'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">out</span><span class="p">,</span><span class="mi">16</span><span class="p">);</span></div><div class='line' id='LC618'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nb">isNaN</span><span class="p">(</span><span class="nx">i</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">isValidCodePoint</span><span class="p">(</span><span class="nx">i</span><span class="p">)</span> <span class="p">)</span> <span class="k">return</span> <span class="nb">String</span><span class="p">.</span><span class="nx">fromCharCode</span><span class="p">(</span><span class="nx">i</span><span class="p">);</span></div><div class='line' id='LC619'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC620'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC621'><br/></div><div class='line' id='LC622'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_parseNumber</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC623'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC624'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">while</span> <span class="p">(</span><span class="nx">input</span><span class="p">.</span><span class="nx">hasNext</span><span class="p">())</span> <span class="p">{</span></div><div class='line' id='LC625'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">ch</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">peek</span><span class="p">();</span></div><div class='line' id='LC626'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nb">isNaN</span><span class="p">(</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">ch</span><span class="p">,</span><span class="mi">10</span><span class="p">)</span> <span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC627'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span> <span class="o">+=</span> <span class="nx">ch</span><span class="p">;</span></div><div class='line' id='LC628'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC629'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="nx">ch</span> <span class="o">==</span> <span class="s1">&#39;;&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC630'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC631'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC632'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC633'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC634'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC635'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC636'><br/></div><div class='line' id='LC637'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">i</span> <span class="o">=</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">out</span><span class="p">,</span><span class="mi">10</span><span class="p">);</span></div><div class='line' id='LC638'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="nb">isNaN</span><span class="p">(</span><span class="nx">i</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">isValidCodePoint</span><span class="p">(</span><span class="nx">i</span><span class="p">)</span> <span class="p">)</span> <span class="k">return</span> <span class="nb">String</span><span class="p">.</span><span class="nx">fromCharCode</span><span class="p">(</span><span class="nx">i</span><span class="p">);</span></div><div class='line' id='LC639'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC640'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC641'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC642'><br/></div><div class='line' id='LC643'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC644'><span class="cm">     * Codec for decoding url-encoded strings.</span></div><div class='line' id='LC645'><span class="cm">     */</span></div><div class='line' id='LC646'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">PercentCodec</span> <span class="o">=</span> <span class="nx">Codec</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC647'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">decodeCharacter</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC648'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">mark</span><span class="p">();</span></div><div class='line' id='LC649'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">first</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC650'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">first</span> <span class="o">==</span> <span class="kc">null</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC651'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC652'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC653'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC654'><br/></div><div class='line' id='LC655'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">first</span> <span class="o">!=</span> <span class="s1">&#39;%&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC656'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC657'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC658'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC659'><br/></div><div class='line' id='LC660'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="s1">&#39;&#39;</span><span class="p">;</span></div><div class='line' id='LC661'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">i</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span><span class="nx">i</span><span class="o">&lt;</span><span class="mi">2</span><span class="p">;</span><span class="nx">i</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC662'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">nextHex</span><span class="p">();</span></div><div class='line' id='LC663'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span><span class="p">(</span> <span class="nx">c</span> <span class="o">!=</span> <span class="kc">null</span> <span class="p">)</span> <span class="nx">out</span> <span class="o">+=</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC664'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC665'><br/></div><div class='line' id='LC666'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">out</span><span class="p">.</span><span class="nx">length</span> <span class="o">==</span> <span class="mi">2</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC667'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">p</span> <span class="o">=</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">out</span><span class="p">,</span> <span class="mi">16</span><span class="p">);</span></div><div class='line' id='LC668'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nx">isValidCodePoint</span><span class="p">(</span><span class="nx">p</span><span class="p">)</span> <span class="p">)</span></div><div class='line' id='LC669'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nb">String</span><span class="p">.</span><span class="nx">fromCharCode</span><span class="p">(</span><span class="nx">p</span><span class="p">);</span></div><div class='line' id='LC670'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC671'><br/></div><div class='line' id='LC672'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC673'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC674'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC675'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC676'><br/></div><div class='line' id='LC677'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC678'><span class="cm">     * Codec for decoding CSS escaped text. This codec will decode both decimal and hex values.</span></div><div class='line' id='LC679'><span class="cm">     */</span></div><div class='line' id='LC680'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">CSSCodec</span> <span class="o">=</span> <span class="nx">Codec</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC681'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">decodeCharacter</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC682'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">mark</span><span class="p">();</span></div><div class='line' id='LC683'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">first</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC684'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">first</span><span class="o">==</span><span class="kc">null</span> <span class="o">||</span> <span class="nx">first</span> <span class="o">!=</span> <span class="s1">&#39;\\&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC685'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC686'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC687'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC688'><br/></div><div class='line' id='LC689'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">second</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC690'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">second</span><span class="o">==</span><span class="kc">null</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC691'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">reset</span><span class="p">();</span></div><div class='line' id='LC692'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC693'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC694'><br/></div><div class='line' id='LC695'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// fallthrough logic is intentional here</span></div><div class='line' id='LC696'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// noinspection FallthroughInSwitchStatementJS</span></div><div class='line' id='LC697'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">switch</span><span class="p">(</span><span class="nx">second</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC698'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">case</span> <span class="s1">&#39;\r&#39;</span><span class="o">:</span></div><div class='line' id='LC699'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">input</span><span class="p">.</span><span class="nx">peek</span><span class="p">(</span><span class="s1">&#39;\n&#39;</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC700'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC701'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC702'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">case</span> <span class="s1">&#39;\n&#39;</span><span class="o">:</span></div><div class='line' id='LC703'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">case</span> <span class="s1">&#39;\f&#39;</span><span class="o">:</span></div><div class='line' id='LC704'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">case</span> <span class="s1">&#39;\u0000&#39;</span><span class="o">:</span></div><div class='line' id='LC705'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">decodeCharacter</span><span class="p">(</span><span class="nx">input</span><span class="p">);</span></div><div class='line' id='LC706'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC707'><br/></div><div class='line' id='LC708'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">second</span><span class="p">,</span><span class="mi">16</span><span class="p">)</span> <span class="o">==</span> <span class="s1">&#39;NaN&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC709'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">second</span><span class="p">;</span></div><div class='line' id='LC710'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC711'><br/></div><div class='line' id='LC712'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">out</span> <span class="o">=</span> <span class="nx">second</span><span class="p">;</span></div><div class='line' id='LC713'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span><span class="p">(</span><span class="kd">var</span> <span class="nx">j</span><span class="o">=</span><span class="mi">0</span><span class="p">;</span><span class="nx">j</span><span class="o">&lt;</span><span class="mi">5</span><span class="p">;</span><span class="nx">j</span><span class="o">++</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC714'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">c</span> <span class="o">=</span> <span class="nx">input</span><span class="p">.</span><span class="nx">next</span><span class="p">();</span></div><div class='line' id='LC715'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">c</span><span class="o">==</span><span class="kc">null</span> <span class="o">||</span> <span class="nx">isWhiteSpace</span><span class="p">(</span><span class="nx">c</span><span class="p">))</span> <span class="p">{</span></div><div class='line' id='LC716'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC717'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC718'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nb">parseInt</span><span class="p">(</span><span class="nx">c</span><span class="p">,</span><span class="mi">16</span><span class="p">)</span> <span class="o">!=</span> <span class="s1">&#39;NaN&#39;</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC719'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">out</span> <span class="o">+=</span> <span class="nx">c</span><span class="p">;</span></div><div class='line' id='LC720'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC721'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">input</span><span class="p">.</span><span class="nx">pushback</span><span class="p">(</span><span class="nx">c</span><span class="p">);</span></div><div class='line' id='LC722'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="p">;</span></div><div class='line' id='LC723'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC724'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC725'><br/></div><div class='line' id='LC726'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">p</span> <span class="o">=</span> <span class="nb">parseInt</span><span class="p">(</span><span class="nx">out</span><span class="p">,</span><span class="mi">16</span><span class="p">);</span></div><div class='line' id='LC727'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">isValidCodePoint</span><span class="p">(</span><span class="nx">p</span><span class="p">))</span></div><div class='line' id='LC728'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nb">String</span><span class="p">.</span><span class="nx">fromCharCode</span><span class="p">(</span><span class="nx">p</span><span class="p">);</span></div><div class='line' id='LC729'><br/></div><div class='line' id='LC730'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="s1">&#39;\ufffd&#39;</span><span class="p">;</span></div><div class='line' id='LC731'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC732'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC733'><br/></div><div class='line' id='LC734'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC735'><span class="cm">     * Trie implementation for Javascript for fast querying and longest matching string lookups.</span></div><div class='line' id='LC736'><span class="cm">     */</span></div><div class='line' id='LC737'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">Trie</span> <span class="o">=</span> <span class="nx">Class</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC738'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">root</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC739'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">maxKeyLen</span><span class="o">:</span> <span class="mi">0</span><span class="p">,</span></div><div class='line' id='LC740'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">size</span><span class="o">:</span> <span class="mi">0</span><span class="p">,</span></div><div class='line' id='LC741'><br/></div><div class='line' id='LC742'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">init</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span> <span class="k">this</span><span class="p">.</span><span class="nx">clear</span><span class="p">();</span> <span class="p">},</span></div><div class='line' id='LC743'><br/></div><div class='line' id='LC744'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">getLongestMatch</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">key</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC745'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="p">(</span> <span class="k">this</span><span class="p">.</span><span class="nx">root</span> <span class="o">==</span> <span class="kc">null</span> <span class="o">&amp;&amp;</span> <span class="nx">key</span> <span class="o">==</span> <span class="kc">null</span> <span class="p">)</span> <span class="o">?</span> <span class="kc">null</span> <span class="o">:</span> <span class="k">this</span><span class="p">.</span><span class="nx">root</span><span class="p">.</span><span class="nx">getLongestMatch</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="mi">0</span><span class="p">);</span></div><div class='line' id='LC746'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC747'><br/></div><div class='line' id='LC748'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">getMaxKeyLength</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span> <span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">maxKeyLen</span><span class="p">;</span> <span class="p">},</span></div><div class='line' id='LC749'><br/></div><div class='line' id='LC750'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">clear</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span> <span class="k">this</span><span class="p">.</span><span class="nx">root</span> <span class="o">=</span> <span class="kc">null</span><span class="p">,</span> <span class="k">this</span><span class="p">.</span><span class="nx">maxKeyLen</span> <span class="o">=</span> <span class="mi">0</span><span class="p">,</span> <span class="k">this</span><span class="p">.</span><span class="nx">size</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="p">},</span></div><div class='line' id='LC751'><br/></div><div class='line' id='LC752'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">put</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">val</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC753'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">len</span><span class="p">,</span> <span class="nx">old</span><span class="p">;</span></div><div class='line' id='LC754'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">root</span><span class="o">==</span><span class="kc">null</span><span class="p">)</span></div><div class='line' id='LC755'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">root</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Node</span><span class="p">();</span></div><div class='line' id='LC756'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">((</span><span class="nx">old</span><span class="o">=</span><span class="k">this</span><span class="p">.</span><span class="nx">root</span><span class="p">.</span><span class="nx">put</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="mi">0</span><span class="p">,</span><span class="nx">val</span><span class="p">))</span><span class="o">!=</span><span class="kc">null</span><span class="p">)</span></div><div class='line' id='LC757'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">old</span><span class="p">;</span></div><div class='line' id='LC758'><br/></div><div class='line' id='LC759'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">((</span><span class="nx">len</span><span class="o">=</span><span class="nx">key</span><span class="p">.</span><span class="nx">length</span><span class="p">)</span> <span class="o">&gt;</span> <span class="k">this</span><span class="p">.</span><span class="nx">maxKeyLen</span> <span class="p">)</span></div><div class='line' id='LC760'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">maxKeyLen</span><span class="o">=</span><span class="nx">key</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span></div><div class='line' id='LC761'><br/></div><div class='line' id='LC762'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">size</span><span class="o">++</span><span class="p">;</span></div><div class='line' id='LC763'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC764'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC765'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC766'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">Trie</span><span class="p">.</span><span class="nx">Entry</span> <span class="o">=</span> <span class="nx">Class</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC767'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_key</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC768'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_value</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC769'><br/></div><div class='line' id='LC770'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">init</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">value</span><span class="p">)</span> <span class="p">{</span> <span class="k">this</span><span class="p">.</span><span class="nx">_key</span> <span class="o">=</span> <span class="nx">key</span><span class="p">,</span> <span class="k">this</span><span class="p">.</span><span class="nx">_value</span> <span class="o">=</span> <span class="nx">value</span><span class="p">;</span> <span class="p">},</span></div><div class='line' id='LC771'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">getKey</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span> <span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_key</span><span class="p">;</span> <span class="p">},</span></div><div class='line' id='LC772'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">getValue</span><span class="o">:</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span> <span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_value</span><span class="p">;</span> <span class="p">},</span></div><div class='line' id='LC773'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">equals</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">other</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC774'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="p">(</span><span class="nx">other</span> <span class="k">instanceof</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Entry</span><span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC775'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC776'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC777'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_key</span> <span class="o">==</span> <span class="nx">other</span><span class="p">.</span><span class="nx">_key</span> <span class="o">&amp;&amp;</span> <span class="k">this</span><span class="p">.</span><span class="nx">_value</span> <span class="o">==</span> <span class="nx">other</span><span class="p">.</span><span class="nx">_value</span><span class="p">;</span></div><div class='line' id='LC778'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC779'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC780'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">Trie</span><span class="p">.</span><span class="nx">Node</span> <span class="o">=</span> <span class="nx">Class</span><span class="p">.</span><span class="nx">extend</span><span class="p">({</span></div><div class='line' id='LC781'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_value</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC782'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">_nextMap</span><span class="o">:</span> <span class="kc">null</span><span class="p">,</span></div><div class='line' id='LC783'><br/></div><div class='line' id='LC784'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">setValue</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">value</span><span class="p">)</span> <span class="p">{</span> <span class="k">this</span><span class="p">.</span><span class="nx">_value</span> <span class="o">=</span> <span class="nx">value</span><span class="p">;</span> <span class="p">},</span></div><div class='line' id='LC785'><br/></div><div class='line' id='LC786'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">getNextNode</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">ch</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC787'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="k">this</span><span class="p">.</span><span class="nx">_nextMap</span> <span class="p">)</span> <span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC788'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_nextMap</span><span class="p">[</span><span class="nx">ch</span><span class="p">];</span></div><div class='line' id='LC789'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC790'><br/></div><div class='line' id='LC791'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC792'><span class="cm">         * Recursively add a key</span></div><div class='line' id='LC793'><span class="cm">         * @param key The key being added</span></div><div class='line' id='LC794'><span class="cm">         * @param pos The position in key that is being handled in this recursion</span></div><div class='line' id='LC795'><span class="cm">         * @param value The value of what that key points to</span></div><div class='line' id='LC796'><span class="cm">         */</span></div><div class='line' id='LC797'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">put</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="p">,</span><span class="nx">value</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC798'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">nextNode</span><span class="p">,</span> <span class="nx">ch</span><span class="p">,</span> <span class="nx">old</span><span class="p">;</span></div><div class='line' id='LC799'><br/></div><div class='line' id='LC800'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Terminating Node Clause (break out of recursion)</span></div><div class='line' id='LC801'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">key</span><span class="p">.</span><span class="nx">length</span> <span class="o">==</span> <span class="nx">pos</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC802'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">old</span> <span class="o">=</span> <span class="k">this</span><span class="p">.</span><span class="nx">_value</span><span class="p">;</span></div><div class='line' id='LC803'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">setValue</span><span class="p">(</span><span class="nx">value</span><span class="p">);</span></div><div class='line' id='LC804'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">old</span><span class="p">;</span></div><div class='line' id='LC805'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC806'><br/></div><div class='line' id='LC807'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">ch</span> <span class="o">=</span> <span class="nx">key</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">pos</span><span class="p">);</span></div><div class='line' id='LC808'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">_nextMap</span><span class="o">==</span><span class="kc">null</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC809'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_nextMap</span> <span class="o">=</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Node</span><span class="p">.</span><span class="nx">newNodeMap</span><span class="p">();</span></div><div class='line' id='LC810'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">nextNode</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Node</span><span class="p">();</span></div><div class='line' id='LC811'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_nextMap</span><span class="p">[</span><span class="nx">ch</span><span class="p">]</span> <span class="o">=</span> <span class="nx">nextNode</span><span class="p">;</span></div><div class='line' id='LC812'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">((</span><span class="nx">nextNode</span><span class="o">=</span><span class="k">this</span><span class="p">.</span><span class="nx">_nextMap</span><span class="p">[</span><span class="nx">ch</span><span class="p">])</span> <span class="o">==</span> <span class="kc">null</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC813'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">nextNode</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Node</span><span class="p">();</span></div><div class='line' id='LC814'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">this</span><span class="p">.</span><span class="nx">_nextMap</span><span class="p">[</span><span class="nx">ch</span><span class="p">]</span> <span class="o">=</span> <span class="nx">nextNode</span><span class="p">;</span></div><div class='line' id='LC815'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC816'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">nextNode</span><span class="p">.</span><span class="nx">put</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="o">+</span><span class="mi">1</span><span class="p">,</span><span class="nx">value</span><span class="p">);</span></div><div class='line' id='LC817'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC818'><br/></div><div class='line' id='LC819'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC820'><span class="cm">         * Recursively lookup a key&#39;s value</span></div><div class='line' id='LC821'><span class="cm">         * @param key The key being looked up</span></div><div class='line' id='LC822'><span class="cm">         * @param pos The position in key that is being handled in this recursion</span></div><div class='line' id='LC823'><span class="cm">         */</span></div><div class='line' id='LC824'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">get</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC825'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">nextNode</span><span class="p">;</span></div><div class='line' id='LC826'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">key</span><span class="p">.</span><span class="nx">length</span> <span class="o">&lt;=</span> <span class="nx">pos</span><span class="p">)</span></div><div class='line' id='LC827'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">this</span><span class="p">.</span><span class="nx">_value</span><span class="p">;</span></div><div class='line' id='LC828'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">((</span><span class="nx">nextNode</span><span class="o">=</span><span class="k">this</span><span class="p">.</span><span class="nx">getNextNode</span><span class="p">(</span><span class="nx">key</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">pos</span><span class="p">)))</span> <span class="o">==</span> <span class="kc">null</span><span class="p">)</span></div><div class='line' id='LC829'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC830'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">nextNode</span><span class="p">.</span><span class="nx">get</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="o">+</span><span class="mi">1</span><span class="p">);</span></div><div class='line' id='LC831'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">},</span></div><div class='line' id='LC832'><br/></div><div class='line' id='LC833'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC834'><span class="cm">         * Recusrsively lookup the longest key match</span></div><div class='line' id='LC835'><span class="cm">         * @param key The key being looked up</span></div><div class='line' id='LC836'><span class="cm">         * @param pos The position in the key for the current recursion</span></div><div class='line' id='LC837'><span class="cm">         */</span></div><div class='line' id='LC838'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">getLongestMatch</span><span class="o">:</span> <span class="kd">function</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC839'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">nextNode</span><span class="p">,</span> <span class="nx">ret</span><span class="p">;</span></div><div class='line' id='LC840'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">key</span><span class="p">.</span><span class="nx">length</span> <span class="o">&lt;=</span> <span class="nx">pos</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC841'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Entry</span><span class="p">.</span><span class="nx">newInstanceIfNeeded</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="k">this</span><span class="p">.</span><span class="nx">_value</span><span class="p">);</span></div><div class='line' id='LC842'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC843'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">((</span><span class="nx">nextNode</span><span class="o">=</span><span class="k">this</span><span class="p">.</span><span class="nx">getNextNode</span><span class="p">(</span><span class="nx">key</span><span class="p">.</span><span class="nx">charAt</span><span class="p">(</span><span class="nx">pos</span><span class="p">)))</span><span class="o">==</span><span class="kc">null</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC844'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Last in Trie - return this value</span></div><div class='line' id='LC845'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Entry</span><span class="p">.</span><span class="nx">newInstanceIfNeeded</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="p">,</span><span class="k">this</span><span class="p">.</span><span class="nx">_value</span><span class="p">);</span></div><div class='line' id='LC846'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC847'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">((</span><span class="nx">ret</span><span class="o">=</span><span class="nx">nextNode</span><span class="p">.</span><span class="nx">getLongestMatch</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="o">+</span><span class="mi">1</span><span class="p">))</span><span class="o">!=</span><span class="kc">null</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC848'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">ret</span><span class="p">;</span></div><div class='line' id='LC849'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC850'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Entry</span><span class="p">.</span><span class="nx">newInstanceIfNeeded</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">pos</span><span class="p">,</span><span class="k">this</span><span class="p">.</span><span class="nx">_value</span><span class="p">);</span></div><div class='line' id='LC851'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC852'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC853'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">Trie</span><span class="p">.</span><span class="nx">Entry</span><span class="p">.</span><span class="nx">newInstanceIfNeeded</span> <span class="o">=</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC854'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">key</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">0</span><span class="p">],</span> <span class="nx">value</span><span class="p">,</span> <span class="nx">keyLength</span><span class="p">;</span></div><div class='line' id='LC855'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="k">typeof</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">1</span><span class="p">]</span> <span class="o">==</span> <span class="s1">&#39;string&#39;</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC856'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">value</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">1</span><span class="p">];</span></div><div class='line' id='LC857'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">keyLength</span> <span class="o">=</span> <span class="nx">key</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span></div><div class='line' id='LC858'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC859'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">keyLength</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">1</span><span class="p">];</span></div><div class='line' id='LC860'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">value</span> <span class="o">=</span> <span class="nx">arguments</span><span class="p">[</span><span class="mi">2</span><span class="p">];</span></div><div class='line' id='LC861'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC862'><br/></div><div class='line' id='LC863'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">value</span><span class="o">==</span><span class="kc">null</span> <span class="o">||</span> <span class="nx">key</span><span class="o">==</span><span class="kc">null</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC864'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">null</span><span class="p">;</span></div><div class='line' id='LC865'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC866'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">key</span><span class="p">.</span><span class="nx">length</span> <span class="o">&gt;</span> <span class="nx">keyLength</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC867'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">key</span> <span class="o">=</span> <span class="nx">key</span><span class="p">.</span><span class="nx">substr</span><span class="p">(</span><span class="mi">0</span><span class="p">,</span><span class="nx">keyLength</span><span class="p">);</span></div><div class='line' id='LC868'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC869'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">new</span> <span class="nx">Trie</span><span class="p">.</span><span class="nx">Entry</span><span class="p">(</span><span class="nx">key</span><span class="p">,</span><span class="nx">value</span><span class="p">);</span></div><div class='line' id='LC870'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC871'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">Trie</span><span class="p">.</span><span class="nx">Node</span><span class="p">.</span><span class="nx">newNodeMap</span> <span class="o">=</span> <span class="kd">function</span><span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC872'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="p">{};</span></div><div class='line' id='LC873'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC874'><br/></div><div class='line' id='LC875'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC876'><span class="cm">     * Match the Java implementation of the isValidCodePoint check</span></div><div class='line' id='LC877'><span class="cm">     * @param codepoint codepoint to check</span></div><div class='line' id='LC878'><span class="cm">     */</span></div><div class='line' id='LC879'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">isValidCodePoint</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">codepoint</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC880'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">codepoint</span> <span class="o">&gt;=</span> <span class="mh">0x0000</span> <span class="o">&amp;&amp;</span> <span class="nx">codepoint</span> <span class="o">&lt;=</span> <span class="mh">0x10FFFF</span><span class="p">;</span></div><div class='line' id='LC881'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC882'><br/></div><div class='line' id='LC883'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC884'><span class="cm">     * Perform a quick whitespace check on the supplied string.</span></div><div class='line' id='LC885'><span class="cm">     * @param input string to check</span></div><div class='line' id='LC886'><span class="cm">     */</span></div><div class='line' id='LC887'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">isWhiteSpace</span> <span class="o">=</span> <span class="kd">function</span><span class="p">(</span><span class="nx">input</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC888'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">input</span><span class="p">.</span><span class="nx">match</span><span class="p">(</span><span class="sr">/[\s]/</span><span class="p">);</span></div><div class='line' id='LC889'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC890'><br/></div><div class='line' id='LC891'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// TODO: There has to be a better way to do this. These are only here for canonicalization</span></div><div class='line' id='LC892'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">MAP_ENTITY_TO_CHAR</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC893'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">MAP_CHAR_TO_ENTITY</span> <span class="o">=</span> <span class="p">[];</span></div><div class='line' id='LC894'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">ENTITY_TO_CHAR_TRIE</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">Trie</span><span class="p">();</span></div><div class='line' id='LC895'><br/></div><div class='line' id='LC896'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="kd">function</span><span class="p">(){</span></div><div class='line' id='LC897'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;quot&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;34&quot;</span><span class="p">;</span></div><div class='line' id='LC898'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 34 : quotation mark */</span></div><div class='line' id='LC899'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;amp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;38&quot;</span><span class="p">;</span></div><div class='line' id='LC900'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 38 : ampersand */</span></div><div class='line' id='LC901'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lt&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;60&quot;</span><span class="p">;</span></div><div class='line' id='LC902'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 60 : less-than sign */</span></div><div class='line' id='LC903'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;gt&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;62&quot;</span><span class="p">;</span></div><div class='line' id='LC904'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 62 : greater-than sign */</span></div><div class='line' id='LC905'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;nbsp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;160&quot;</span><span class="p">;</span></div><div class='line' id='LC906'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 160 : no-break space */</span></div><div class='line' id='LC907'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;iexcl&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;161&quot;</span><span class="p">;</span></div><div class='line' id='LC908'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 161 : inverted exclamation mark */</span></div><div class='line' id='LC909'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;cent&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;162&quot;</span><span class="p">;</span></div><div class='line' id='LC910'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 162  : cent sign */</span></div><div class='line' id='LC911'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;pound&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;163&quot;</span><span class="p">;</span></div><div class='line' id='LC912'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 163  : pound sign */</span></div><div class='line' id='LC913'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;curren&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;164&quot;</span><span class="p">;</span></div><div class='line' id='LC914'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 164  : currency sign */</span></div><div class='line' id='LC915'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;yen&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;165&quot;</span><span class="p">;</span></div><div class='line' id='LC916'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 165  : yen sign */</span></div><div class='line' id='LC917'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;brvbar&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;166&quot;</span><span class="p">;</span></div><div class='line' id='LC918'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 166  : broken bar */</span></div><div class='line' id='LC919'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sect&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;167&quot;</span><span class="p">;</span></div><div class='line' id='LC920'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 167  : section sign */</span></div><div class='line' id='LC921'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;uml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;168&quot;</span><span class="p">;</span></div><div class='line' id='LC922'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 168  : diaeresis */</span></div><div class='line' id='LC923'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;copy&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;169&quot;</span><span class="p">;</span></div><div class='line' id='LC924'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 169  : copyright sign */</span></div><div class='line' id='LC925'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ordf&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;170&quot;</span><span class="p">;</span></div><div class='line' id='LC926'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 170  : feminine ordinal indicator */</span></div><div class='line' id='LC927'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;laquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;171&quot;</span><span class="p">;</span></div><div class='line' id='LC928'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 171 : left-pointing double angle quotation mark */</span></div><div class='line' id='LC929'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;not&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;172&quot;</span><span class="p">;</span></div><div class='line' id='LC930'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 172  : not sign */</span></div><div class='line' id='LC931'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;shy&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;173&quot;</span><span class="p">;</span></div><div class='line' id='LC932'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 173  : soft hyphen */</span></div><div class='line' id='LC933'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;reg&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;174&quot;</span><span class="p">;</span></div><div class='line' id='LC934'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 174  : registered sign */</span></div><div class='line' id='LC935'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;macr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;175&quot;</span><span class="p">;</span></div><div class='line' id='LC936'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 175  : macron */</span></div><div class='line' id='LC937'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;deg&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;176&quot;</span><span class="p">;</span></div><div class='line' id='LC938'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 176  : degree sign */</span></div><div class='line' id='LC939'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;plusmn&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;177&quot;</span><span class="p">;</span></div><div class='line' id='LC940'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 177 : plus-minus sign */</span></div><div class='line' id='LC941'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sup2&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;178&quot;</span><span class="p">;</span></div><div class='line' id='LC942'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 178  : superscript two */</span></div><div class='line' id='LC943'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sup3&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;179&quot;</span><span class="p">;</span></div><div class='line' id='LC944'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 179  : superscript three */</span></div><div class='line' id='LC945'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;acute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;180&quot;</span><span class="p">;</span></div><div class='line' id='LC946'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 180  : acute accent */</span></div><div class='line' id='LC947'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;micro&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;181&quot;</span><span class="p">;</span></div><div class='line' id='LC948'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 181  : micro sign */</span></div><div class='line' id='LC949'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;para&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;182&quot;</span><span class="p">;</span></div><div class='line' id='LC950'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 182  : pilcrow sign */</span></div><div class='line' id='LC951'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;middot&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;183&quot;</span><span class="p">;</span></div><div class='line' id='LC952'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 183  : middle dot */</span></div><div class='line' id='LC953'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;cedil&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;184&quot;</span><span class="p">;</span></div><div class='line' id='LC954'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 184  : cedilla */</span></div><div class='line' id='LC955'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sup1&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;185&quot;</span><span class="p">;</span></div><div class='line' id='LC956'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 185  : superscript one */</span></div><div class='line' id='LC957'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ordm&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;186&quot;</span><span class="p">;</span></div><div class='line' id='LC958'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 186  : masculine ordinal indicator */</span></div><div class='line' id='LC959'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;raquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;187&quot;</span><span class="p">;</span></div><div class='line' id='LC960'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 187 : right-pointing double angle quotation mark */</span></div><div class='line' id='LC961'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;frac14&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;188&quot;</span><span class="p">;</span></div><div class='line' id='LC962'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 188  : vulgar fraction one quarter */</span></div><div class='line' id='LC963'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;frac12&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;189&quot;</span><span class="p">;</span></div><div class='line' id='LC964'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 189  : vulgar fraction one half */</span></div><div class='line' id='LC965'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;frac34&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;190&quot;</span><span class="p">;</span></div><div class='line' id='LC966'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 190  : vulgar fraction three quarters */</span></div><div class='line' id='LC967'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;iquest&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;191&quot;</span><span class="p">;</span></div><div class='line' id='LC968'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 191  : inverted question mark */</span></div><div class='line' id='LC969'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Agrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;192&quot;</span><span class="p">;</span></div><div class='line' id='LC970'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 192  : Latin capital letter a with grave */</span></div><div class='line' id='LC971'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Aacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;193&quot;</span><span class="p">;</span></div><div class='line' id='LC972'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 193  : Latin capital letter a with acute */</span></div><div class='line' id='LC973'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Acirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;194&quot;</span><span class="p">;</span></div><div class='line' id='LC974'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 194  : Latin capital letter a with circumflex */</span></div><div class='line' id='LC975'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Atilde&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;195&quot;</span><span class="p">;</span></div><div class='line' id='LC976'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 195  : Latin capital letter a with tilde */</span></div><div class='line' id='LC977'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Auml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;196&quot;</span><span class="p">;</span></div><div class='line' id='LC978'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 196  : Latin capital letter a with diaeresis */</span></div><div class='line' id='LC979'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Aring&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;197&quot;</span><span class="p">;</span></div><div class='line' id='LC980'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 197  : Latin capital letter a with ring above */</span></div><div class='line' id='LC981'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;AElig&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;198&quot;</span><span class="p">;</span></div><div class='line' id='LC982'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 198  : Latin capital letter ae */</span></div><div class='line' id='LC983'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ccedil&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;199&quot;</span><span class="p">;</span></div><div class='line' id='LC984'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 199  : Latin capital letter c with cedilla */</span></div><div class='line' id='LC985'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Egrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;200&quot;</span><span class="p">;</span></div><div class='line' id='LC986'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 200  : Latin capital letter e with grave */</span></div><div class='line' id='LC987'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Eacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;201&quot;</span><span class="p">;</span></div><div class='line' id='LC988'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 201  : Latin capital letter e with acute */</span></div><div class='line' id='LC989'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ecirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;202&quot;</span><span class="p">;</span></div><div class='line' id='LC990'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 202  : Latin capital letter e with circumflex */</span></div><div class='line' id='LC991'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Euml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;203&quot;</span><span class="p">;</span></div><div class='line' id='LC992'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 203  : Latin capital letter e with diaeresis */</span></div><div class='line' id='LC993'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Igrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;204&quot;</span><span class="p">;</span></div><div class='line' id='LC994'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 204  : Latin capital letter i with grave */</span></div><div class='line' id='LC995'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Iacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;205&quot;</span><span class="p">;</span></div><div class='line' id='LC996'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 205  : Latin capital letter i with acute */</span></div><div class='line' id='LC997'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Icirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;206&quot;</span><span class="p">;</span></div><div class='line' id='LC998'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 206  : Latin capital letter i with circumflex */</span></div><div class='line' id='LC999'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Iuml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;207&quot;</span><span class="p">;</span></div><div class='line' id='LC1000'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 207  : Latin capital letter i with diaeresis */</span></div><div class='line' id='LC1001'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ETH&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;208&quot;</span><span class="p">;</span></div><div class='line' id='LC1002'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 208  : Latin capital letter eth */</span></div><div class='line' id='LC1003'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ntilde&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;209&quot;</span><span class="p">;</span></div><div class='line' id='LC1004'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 209  : Latin capital letter n with tilde */</span></div><div class='line' id='LC1005'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ograve&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;210&quot;</span><span class="p">;</span></div><div class='line' id='LC1006'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 210  : Latin capital letter o with grave */</span></div><div class='line' id='LC1007'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Oacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;211&quot;</span><span class="p">;</span></div><div class='line' id='LC1008'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 211  : Latin capital letter o with acute */</span></div><div class='line' id='LC1009'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ocirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;212&quot;</span><span class="p">;</span></div><div class='line' id='LC1010'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 212 : Latin capital letter o with circumflex */</span></div><div class='line' id='LC1011'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Otilde&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;213&quot;</span><span class="p">;</span></div><div class='line' id='LC1012'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 213 : Latin capital letter o with tilde */</span></div><div class='line' id='LC1013'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ouml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;214&quot;</span><span class="p">;</span></div><div class='line' id='LC1014'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 214 : Latin capital letter o with diaeresis */</span></div><div class='line' id='LC1015'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;times&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;215&quot;</span><span class="p">;</span></div><div class='line' id='LC1016'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 215 : multiplication sign */</span></div><div class='line' id='LC1017'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Oslash&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;216&quot;</span><span class="p">;</span></div><div class='line' id='LC1018'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 216 : Latin capital letter o with stroke */</span></div><div class='line' id='LC1019'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ugrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;217&quot;</span><span class="p">;</span></div><div class='line' id='LC1020'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 217 : Latin capital letter u with grave */</span></div><div class='line' id='LC1021'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Uacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;218&quot;</span><span class="p">;</span></div><div class='line' id='LC1022'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 218 : Latin capital letter u with acute */</span></div><div class='line' id='LC1023'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Ucirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;219&quot;</span><span class="p">;</span></div><div class='line' id='LC1024'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 219 : Latin capital letter u with circumflex */</span></div><div class='line' id='LC1025'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Uuml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;220&quot;</span><span class="p">;</span></div><div class='line' id='LC1026'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 220 : Latin capital letter u with diaeresis */</span></div><div class='line' id='LC1027'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Yacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;221&quot;</span><span class="p">;</span></div><div class='line' id='LC1028'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 221 : Latin capital letter y with acute */</span></div><div class='line' id='LC1029'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;THORN&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;222&quot;</span><span class="p">;</span></div><div class='line' id='LC1030'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 222 : Latin capital letter thorn */</span></div><div class='line' id='LC1031'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;szlig&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;223&quot;</span><span class="p">;</span></div><div class='line' id='LC1032'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 223 : Latin small letter sharp s, German Eszett */</span></div><div class='line' id='LC1033'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;agrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;224&quot;</span><span class="p">;</span></div><div class='line' id='LC1034'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 224 : Latin small letter a with grave */</span></div><div class='line' id='LC1035'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;aacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;225&quot;</span><span class="p">;</span></div><div class='line' id='LC1036'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 225 : Latin small letter a with acute */</span></div><div class='line' id='LC1037'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;acirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;226&quot;</span><span class="p">;</span></div><div class='line' id='LC1038'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 226 : Latin small letter a with circumflex */</span></div><div class='line' id='LC1039'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;atilde&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;227&quot;</span><span class="p">;</span></div><div class='line' id='LC1040'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 227 : Latin small letter a with tilde */</span></div><div class='line' id='LC1041'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;auml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;228&quot;</span><span class="p">;</span></div><div class='line' id='LC1042'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 228 : Latin small letter a with diaeresis */</span></div><div class='line' id='LC1043'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;aring&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;229&quot;</span><span class="p">;</span></div><div class='line' id='LC1044'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 229 : Latin small letter a with ring above */</span></div><div class='line' id='LC1045'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;aelig&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;230&quot;</span><span class="p">;</span></div><div class='line' id='LC1046'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 230 : Latin lowercase ligature ae */</span></div><div class='line' id='LC1047'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ccedil&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;231&quot;</span><span class="p">;</span></div><div class='line' id='LC1048'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 231 : Latin small letter c with cedilla */</span></div><div class='line' id='LC1049'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;egrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;232&quot;</span><span class="p">;</span></div><div class='line' id='LC1050'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 232 : Latin small letter e with grave */</span></div><div class='line' id='LC1051'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;eacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;233&quot;</span><span class="p">;</span></div><div class='line' id='LC1052'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 233 : Latin small letter e with acute */</span></div><div class='line' id='LC1053'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ecirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;234&quot;</span><span class="p">;</span></div><div class='line' id='LC1054'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 234 : Latin small letter e with circumflex */</span></div><div class='line' id='LC1055'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;euml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;235&quot;</span><span class="p">;</span></div><div class='line' id='LC1056'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 235 : Latin small letter e with diaeresis */</span></div><div class='line' id='LC1057'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;igrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;236&quot;</span><span class="p">;</span></div><div class='line' id='LC1058'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 236 : Latin small letter i with grave */</span></div><div class='line' id='LC1059'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;iacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;237&quot;</span><span class="p">;</span></div><div class='line' id='LC1060'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 237 : Latin small letter i with acute */</span></div><div class='line' id='LC1061'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;icirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;238&quot;</span><span class="p">;</span></div><div class='line' id='LC1062'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 238 : Latin small letter i with circumflex */</span></div><div class='line' id='LC1063'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;iuml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;239&quot;</span><span class="p">;</span></div><div class='line' id='LC1064'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 239 : Latin small letter i with diaeresis */</span></div><div class='line' id='LC1065'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;eth&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;240&quot;</span><span class="p">;</span></div><div class='line' id='LC1066'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 240 : Latin small letter eth */</span></div><div class='line' id='LC1067'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ntilde&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;241&quot;</span><span class="p">;</span></div><div class='line' id='LC1068'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 241 : Latin small letter n with tilde */</span></div><div class='line' id='LC1069'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ograve&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;242&quot;</span><span class="p">;</span></div><div class='line' id='LC1070'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 242 : Latin small letter o with grave */</span></div><div class='line' id='LC1071'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;oacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;243&quot;</span><span class="p">;</span></div><div class='line' id='LC1072'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 243 : Latin small letter o with acute */</span></div><div class='line' id='LC1073'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ocirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;244&quot;</span><span class="p">;</span></div><div class='line' id='LC1074'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 244 : Latin small letter o with circumflex */</span></div><div class='line' id='LC1075'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;otilde&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;245&quot;</span><span class="p">;</span></div><div class='line' id='LC1076'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 245 : Latin small letter o with tilde */</span></div><div class='line' id='LC1077'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ouml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;246&quot;</span><span class="p">;</span></div><div class='line' id='LC1078'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 246 : Latin small letter o with diaeresis */</span></div><div class='line' id='LC1079'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;divide&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;247&quot;</span><span class="p">;</span></div><div class='line' id='LC1080'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 247 : division sign */</span></div><div class='line' id='LC1081'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;oslash&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;248&quot;</span><span class="p">;</span></div><div class='line' id='LC1082'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 248 : Latin small letter o with stroke */</span></div><div class='line' id='LC1083'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ugrave&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;249&quot;</span><span class="p">;</span></div><div class='line' id='LC1084'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 249 : Latin small letter u with grave */</span></div><div class='line' id='LC1085'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;uacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;250&quot;</span><span class="p">;</span></div><div class='line' id='LC1086'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 250 : Latin small letter u with acute */</span></div><div class='line' id='LC1087'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ucirc&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;251&quot;</span><span class="p">;</span></div><div class='line' id='LC1088'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 251 : Latin small letter u with circumflex */</span></div><div class='line' id='LC1089'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;uuml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;252&quot;</span><span class="p">;</span></div><div class='line' id='LC1090'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 252 : Latin small letter u with diaeresis */</span></div><div class='line' id='LC1091'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;yacute&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;253&quot;</span><span class="p">;</span></div><div class='line' id='LC1092'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 253 : Latin small letter y with acute */</span></div><div class='line' id='LC1093'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;thorn&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;254&quot;</span><span class="p">;</span></div><div class='line' id='LC1094'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 254 : Latin small letter thorn */</span></div><div class='line' id='LC1095'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;yuml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;255&quot;</span><span class="p">;</span></div><div class='line' id='LC1096'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 255 : Latin small letter y with diaeresis */</span></div><div class='line' id='LC1097'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;OElig&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;338&quot;</span><span class="p">;</span></div><div class='line' id='LC1098'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 338 : Latin capital ligature oe */</span></div><div class='line' id='LC1099'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;oelig&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;339&quot;</span><span class="p">;</span></div><div class='line' id='LC1100'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 339 : Latin small ligature oe */</span></div><div class='line' id='LC1101'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Scaron&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;352&quot;</span><span class="p">;</span></div><div class='line' id='LC1102'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 352 : Latin capital letter s with caron */</span></div><div class='line' id='LC1103'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;scaron&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;353&quot;</span><span class="p">;</span></div><div class='line' id='LC1104'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 353 : Latin small letter s with caron */</span></div><div class='line' id='LC1105'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Yuml&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;376&quot;</span><span class="p">;</span></div><div class='line' id='LC1106'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 376 : Latin capital letter y with diaeresis */</span></div><div class='line' id='LC1107'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;fnof&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;402&quot;</span><span class="p">;</span></div><div class='line' id='LC1108'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 402 : Latin small letter f with hook */</span></div><div class='line' id='LC1109'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;circ&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;710&quot;</span><span class="p">;</span></div><div class='line' id='LC1110'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 710 : modifier letter circumflex accent */</span></div><div class='line' id='LC1111'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;tilde&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;732&quot;</span><span class="p">;</span></div><div class='line' id='LC1112'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 732 : small tilde */</span></div><div class='line' id='LC1113'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Alpha&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;913&quot;</span><span class="p">;</span></div><div class='line' id='LC1114'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 913 : Greek capital letter alpha */</span></div><div class='line' id='LC1115'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Beta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;914&quot;</span><span class="p">;</span></div><div class='line' id='LC1116'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 914 : Greek capital letter beta */</span></div><div class='line' id='LC1117'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Gamma&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;915&quot;</span><span class="p">;</span></div><div class='line' id='LC1118'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 915 : Greek capital letter gamma */</span></div><div class='line' id='LC1119'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Delta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;916&quot;</span><span class="p">;</span></div><div class='line' id='LC1120'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 916 : Greek capital letter delta */</span></div><div class='line' id='LC1121'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Epsilon&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;917&quot;</span><span class="p">;</span></div><div class='line' id='LC1122'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 917 : Greek capital letter epsilon */</span></div><div class='line' id='LC1123'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Zeta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;918&quot;</span><span class="p">;</span></div><div class='line' id='LC1124'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 918 : Greek capital letter zeta */</span></div><div class='line' id='LC1125'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Eta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;919&quot;</span><span class="p">;</span></div><div class='line' id='LC1126'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 919 : Greek capital letter eta */</span></div><div class='line' id='LC1127'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Theta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;920&quot;</span><span class="p">;</span></div><div class='line' id='LC1128'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 920 : Greek capital letter theta */</span></div><div class='line' id='LC1129'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Iota&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;921&quot;</span><span class="p">;</span></div><div class='line' id='LC1130'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 921 : Greek capital letter iota */</span></div><div class='line' id='LC1131'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Kappa&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;922&quot;</span><span class="p">;</span></div><div class='line' id='LC1132'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 922 : Greek capital letter kappa */</span></div><div class='line' id='LC1133'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Lambda&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;923&quot;</span><span class="p">;</span></div><div class='line' id='LC1134'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 923 : Greek capital letter lambda */</span></div><div class='line' id='LC1135'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Mu&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;924&quot;</span><span class="p">;</span></div><div class='line' id='LC1136'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 924 : Greek capital letter mu */</span></div><div class='line' id='LC1137'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Nu&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;925&quot;</span><span class="p">;</span></div><div class='line' id='LC1138'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 925 : Greek capital letter nu */</span></div><div class='line' id='LC1139'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Xi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;926&quot;</span><span class="p">;</span></div><div class='line' id='LC1140'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 926 : Greek capital letter xi */</span></div><div class='line' id='LC1141'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Omicron&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;927&quot;</span><span class="p">;</span></div><div class='line' id='LC1142'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 927 : Greek capital letter omicron */</span></div><div class='line' id='LC1143'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Pi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;928&quot;</span><span class="p">;</span></div><div class='line' id='LC1144'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 928 : Greek capital letter pi */</span></div><div class='line' id='LC1145'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Rho&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;929&quot;</span><span class="p">;</span></div><div class='line' id='LC1146'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 929 : Greek capital letter rho */</span></div><div class='line' id='LC1147'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Sigma&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;931&quot;</span><span class="p">;</span></div><div class='line' id='LC1148'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 931 : Greek capital letter sigma */</span></div><div class='line' id='LC1149'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Tau&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;932&quot;</span><span class="p">;</span></div><div class='line' id='LC1150'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 932 : Greek capital letter tau */</span></div><div class='line' id='LC1151'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Upsilon&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;933&quot;</span><span class="p">;</span></div><div class='line' id='LC1152'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 933 : Greek capital letter upsilon */</span></div><div class='line' id='LC1153'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Phi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;934&quot;</span><span class="p">;</span></div><div class='line' id='LC1154'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 934 : Greek capital letter phi */</span></div><div class='line' id='LC1155'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Chi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;935&quot;</span><span class="p">;</span></div><div class='line' id='LC1156'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 935 : Greek capital letter chi */</span></div><div class='line' id='LC1157'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Psi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;936&quot;</span><span class="p">;</span></div><div class='line' id='LC1158'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 936 : Greek capital letter psi */</span></div><div class='line' id='LC1159'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Omega&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;937&quot;</span><span class="p">;</span></div><div class='line' id='LC1160'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 937 : Greek capital letter omega */</span></div><div class='line' id='LC1161'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;alpha&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;945&quot;</span><span class="p">;</span></div><div class='line' id='LC1162'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 945 : Greek small letter alpha */</span></div><div class='line' id='LC1163'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;beta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;946&quot;</span><span class="p">;</span></div><div class='line' id='LC1164'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 946 : Greek small letter beta */</span></div><div class='line' id='LC1165'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;gamma&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;947&quot;</span><span class="p">;</span></div><div class='line' id='LC1166'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 947 : Greek small letter gamma */</span></div><div class='line' id='LC1167'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;delta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;948&quot;</span><span class="p">;</span></div><div class='line' id='LC1168'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 948 : Greek small letter delta */</span></div><div class='line' id='LC1169'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;epsilon&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;949&quot;</span><span class="p">;</span></div><div class='line' id='LC1170'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 949 : Greek small letter epsilon */</span></div><div class='line' id='LC1171'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;zeta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;950&quot;</span><span class="p">;</span></div><div class='line' id='LC1172'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 950 : Greek small letter zeta */</span></div><div class='line' id='LC1173'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;eta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;951&quot;</span><span class="p">;</span></div><div class='line' id='LC1174'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 951 : Greek small letter eta */</span></div><div class='line' id='LC1175'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;theta&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;952&quot;</span><span class="p">;</span></div><div class='line' id='LC1176'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 952 : Greek small letter theta */</span></div><div class='line' id='LC1177'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;iota&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;953&quot;</span><span class="p">;</span></div><div class='line' id='LC1178'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 953 : Greek small letter iota */</span></div><div class='line' id='LC1179'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;kappa&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;954&quot;</span><span class="p">;</span></div><div class='line' id='LC1180'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 954 : Greek small letter kappa */</span></div><div class='line' id='LC1181'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lambda&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;955&quot;</span><span class="p">;</span></div><div class='line' id='LC1182'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 955 : Greek small letter lambda */</span></div><div class='line' id='LC1183'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;mu&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;956&quot;</span><span class="p">;</span></div><div class='line' id='LC1184'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 956 : Greek small letter mu */</span></div><div class='line' id='LC1185'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;nu&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;957&quot;</span><span class="p">;</span></div><div class='line' id='LC1186'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 957 : Greek small letter nu */</span></div><div class='line' id='LC1187'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;xi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;958&quot;</span><span class="p">;</span></div><div class='line' id='LC1188'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 958 : Greek small letter xi */</span></div><div class='line' id='LC1189'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;omicron&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;959&quot;</span><span class="p">;</span></div><div class='line' id='LC1190'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 959 : Greek small letter omicron */</span></div><div class='line' id='LC1191'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;pi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;960&quot;</span><span class="p">;</span></div><div class='line' id='LC1192'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 960 : Greek small letter pi */</span></div><div class='line' id='LC1193'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rho&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;961&quot;</span><span class="p">;</span></div><div class='line' id='LC1194'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 961 : Greek small letter rho */</span></div><div class='line' id='LC1195'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sigmaf&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;962&quot;</span><span class="p">;</span></div><div class='line' id='LC1196'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 962 : Greek small letter final sigma */</span></div><div class='line' id='LC1197'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sigma&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;963&quot;</span><span class="p">;</span></div><div class='line' id='LC1198'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 963 : Greek small letter sigma */</span></div><div class='line' id='LC1199'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;tau&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;964&quot;</span><span class="p">;</span></div><div class='line' id='LC1200'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 964 : Greek small letter tau */</span></div><div class='line' id='LC1201'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;upsilon&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;965&quot;</span><span class="p">;</span></div><div class='line' id='LC1202'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 965 : Greek small letter upsilon */</span></div><div class='line' id='LC1203'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;phi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;966&quot;</span><span class="p">;</span></div><div class='line' id='LC1204'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 966 : Greek small letter phi */</span></div><div class='line' id='LC1205'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;chi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;967&quot;</span><span class="p">;</span></div><div class='line' id='LC1206'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 967 : Greek small letter chi */</span></div><div class='line' id='LC1207'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;psi&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;968&quot;</span><span class="p">;</span></div><div class='line' id='LC1208'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 968 : Greek small letter psi */</span></div><div class='line' id='LC1209'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;omega&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;969&quot;</span><span class="p">;</span></div><div class='line' id='LC1210'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 969 : Greek small letter omega */</span></div><div class='line' id='LC1211'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;thetasym&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;977&quot;</span><span class="p">;</span></div><div class='line' id='LC1212'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 977 : Greek theta symbol */</span></div><div class='line' id='LC1213'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;upsih&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;978&quot;</span><span class="p">;</span></div><div class='line' id='LC1214'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 978 : Greek upsilon with hook symbol */</span></div><div class='line' id='LC1215'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;piv&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;982&quot;</span><span class="p">;</span></div><div class='line' id='LC1216'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 982 : Greek pi symbol */</span></div><div class='line' id='LC1217'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ensp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8194&quot;</span><span class="p">;</span></div><div class='line' id='LC1218'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8194 : en space */</span></div><div class='line' id='LC1219'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;emsp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8195&quot;</span><span class="p">;</span></div><div class='line' id='LC1220'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8195 : em space */</span></div><div class='line' id='LC1221'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;thinsp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8201&quot;</span><span class="p">;</span></div><div class='line' id='LC1222'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8201 : thin space */</span></div><div class='line' id='LC1223'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;zwnj&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8204&quot;</span><span class="p">;</span></div><div class='line' id='LC1224'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8204 : zero width non-joiner */</span></div><div class='line' id='LC1225'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;zwj&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8205&quot;</span><span class="p">;</span></div><div class='line' id='LC1226'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8205 : zero width joiner */</span></div><div class='line' id='LC1227'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lrm&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8206&quot;</span><span class="p">;</span></div><div class='line' id='LC1228'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8206 : left-to-right mark */</span></div><div class='line' id='LC1229'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rlm&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8207&quot;</span><span class="p">;</span></div><div class='line' id='LC1230'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8207 : right-to-left mark */</span></div><div class='line' id='LC1231'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ndash&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8211&quot;</span><span class="p">;</span></div><div class='line' id='LC1232'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8211 : en dash */</span></div><div class='line' id='LC1233'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;mdash&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8212&quot;</span><span class="p">;</span></div><div class='line' id='LC1234'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8212 : em dash */</span></div><div class='line' id='LC1235'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lsquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8216&quot;</span><span class="p">;</span></div><div class='line' id='LC1236'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8216 : left single quotation mark */</span></div><div class='line' id='LC1237'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rsquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8217&quot;</span><span class="p">;</span></div><div class='line' id='LC1238'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8217 : right single quotation mark */</span></div><div class='line' id='LC1239'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sbquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8218&quot;</span><span class="p">;</span></div><div class='line' id='LC1240'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8218 : single low-9 quotation mark */</span></div><div class='line' id='LC1241'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ldquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8220&quot;</span><span class="p">;</span></div><div class='line' id='LC1242'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8220 : left double quotation mark */</span></div><div class='line' id='LC1243'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rdquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8221&quot;</span><span class="p">;</span></div><div class='line' id='LC1244'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8221 : right double quotation mark */</span></div><div class='line' id='LC1245'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;bdquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8222&quot;</span><span class="p">;</span></div><div class='line' id='LC1246'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8222 : double low-9 quotation mark */</span></div><div class='line' id='LC1247'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;dagger&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8224&quot;</span><span class="p">;</span></div><div class='line' id='LC1248'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8224 : dagger */</span></div><div class='line' id='LC1249'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Dagger&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8225&quot;</span><span class="p">;</span></div><div class='line' id='LC1250'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8225 : double dagger */</span></div><div class='line' id='LC1251'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;bull&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8226&quot;</span><span class="p">;</span></div><div class='line' id='LC1252'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8226 : bullet */</span></div><div class='line' id='LC1253'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;hellip&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8230&quot;</span><span class="p">;</span></div><div class='line' id='LC1254'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8230 : horizontal ellipsis */</span></div><div class='line' id='LC1255'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;permil&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8240&quot;</span><span class="p">;</span></div><div class='line' id='LC1256'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8240 : per mille sign */</span></div><div class='line' id='LC1257'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;prime&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8242&quot;</span><span class="p">;</span></div><div class='line' id='LC1258'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8242 : prime */</span></div><div class='line' id='LC1259'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;Prime&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8243&quot;</span><span class="p">;</span></div><div class='line' id='LC1260'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8243 : double prime */</span></div><div class='line' id='LC1261'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lsaquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8249&quot;</span><span class="p">;</span></div><div class='line' id='LC1262'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8249 : single left-pointing angle quotation mark */</span></div><div class='line' id='LC1263'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rsaquo&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8250&quot;</span><span class="p">;</span></div><div class='line' id='LC1264'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8250 : single right-pointing angle quotation mark */</span></div><div class='line' id='LC1265'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;oline&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8254&quot;</span><span class="p">;</span></div><div class='line' id='LC1266'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8254 : overline */</span></div><div class='line' id='LC1267'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;frasl&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8260&quot;</span><span class="p">;</span></div><div class='line' id='LC1268'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8260 : fraction slash */</span></div><div class='line' id='LC1269'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;euro&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8364&quot;</span><span class="p">;</span></div><div class='line' id='LC1270'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8364 : euro sign */</span></div><div class='line' id='LC1271'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;image&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8365&quot;</span><span class="p">;</span></div><div class='line' id='LC1272'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8465 : black-letter capital i */</span></div><div class='line' id='LC1273'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;weierp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8472&quot;</span><span class="p">;</span></div><div class='line' id='LC1274'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8472 : script capital p, Weierstrass p */</span></div><div class='line' id='LC1275'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;real&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8476&quot;</span><span class="p">;</span></div><div class='line' id='LC1276'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8476 : black-letter capital r */</span></div><div class='line' id='LC1277'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;trade&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8482&quot;</span><span class="p">;</span></div><div class='line' id='LC1278'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8482 : trademark sign */</span></div><div class='line' id='LC1279'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;alefsym&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8501&quot;</span><span class="p">;</span></div><div class='line' id='LC1280'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8501 : alef symbol */</span></div><div class='line' id='LC1281'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;larr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8592&quot;</span><span class="p">;</span></div><div class='line' id='LC1282'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8592 : leftwards arrow */</span></div><div class='line' id='LC1283'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;uarr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8593&quot;</span><span class="p">;</span></div><div class='line' id='LC1284'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8593 : upwards arrow */</span></div><div class='line' id='LC1285'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rarr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8594&quot;</span><span class="p">;</span></div><div class='line' id='LC1286'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8594 : rightwards arrow */</span></div><div class='line' id='LC1287'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;darr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8595&quot;</span><span class="p">;</span></div><div class='line' id='LC1288'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8595 : downwards arrow */</span></div><div class='line' id='LC1289'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;harr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8596&quot;</span><span class="p">;</span></div><div class='line' id='LC1290'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8596 : left right arrow */</span></div><div class='line' id='LC1291'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;crarr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8629&quot;</span><span class="p">;</span></div><div class='line' id='LC1292'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8629 : downwards arrow with corner leftwards */</span></div><div class='line' id='LC1293'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lArr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8656&quot;</span><span class="p">;</span></div><div class='line' id='LC1294'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8656 : leftwards double arrow */</span></div><div class='line' id='LC1295'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;uArr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8657&quot;</span><span class="p">;</span></div><div class='line' id='LC1296'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8657 : upwards double arrow */</span></div><div class='line' id='LC1297'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rArr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8658&quot;</span><span class="p">;</span></div><div class='line' id='LC1298'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8658 : rightwards double arrow */</span></div><div class='line' id='LC1299'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;dArr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8659&quot;</span><span class="p">;</span></div><div class='line' id='LC1300'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8659 : downwards double arrow */</span></div><div class='line' id='LC1301'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;hArr&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8660&quot;</span><span class="p">;</span></div><div class='line' id='LC1302'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8660 : left right double arrow */</span></div><div class='line' id='LC1303'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;forall&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8704&quot;</span><span class="p">;</span></div><div class='line' id='LC1304'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8704 : for all */</span></div><div class='line' id='LC1305'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;part&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8706&quot;</span><span class="p">;</span></div><div class='line' id='LC1306'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8706 : partial differential */</span></div><div class='line' id='LC1307'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;exist&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8707&quot;</span><span class="p">;</span></div><div class='line' id='LC1308'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8707 : there exists */</span></div><div class='line' id='LC1309'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;empty&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8709&quot;</span><span class="p">;</span></div><div class='line' id='LC1310'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8709 : empty set */</span></div><div class='line' id='LC1311'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;nabla&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8711&quot;</span><span class="p">;</span></div><div class='line' id='LC1312'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8711 : nabla */</span></div><div class='line' id='LC1313'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;isin&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8712&quot;</span><span class="p">;</span></div><div class='line' id='LC1314'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8712 : element of */</span></div><div class='line' id='LC1315'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;notin&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8713&quot;</span><span class="p">;</span></div><div class='line' id='LC1316'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8713 : not an element of */</span></div><div class='line' id='LC1317'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ni&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8715&quot;</span><span class="p">;</span></div><div class='line' id='LC1318'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8715 : contains as member */</span></div><div class='line' id='LC1319'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;prod&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8719&quot;</span><span class="p">;</span></div><div class='line' id='LC1320'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8719 : n-ary product */</span></div><div class='line' id='LC1321'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sum&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8721&quot;</span><span class="p">;</span></div><div class='line' id='LC1322'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8721 : n-ary summation */</span></div><div class='line' id='LC1323'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;minus&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8722&quot;</span><span class="p">;</span></div><div class='line' id='LC1324'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8722 : minus sign */</span></div><div class='line' id='LC1325'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lowast&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8727&quot;</span><span class="p">;</span></div><div class='line' id='LC1326'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8727 : asterisk operator */</span></div><div class='line' id='LC1327'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;radic&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8730&quot;</span><span class="p">;</span></div><div class='line' id='LC1328'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8730 : square root */</span></div><div class='line' id='LC1329'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;prop&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8733&quot;</span><span class="p">;</span></div><div class='line' id='LC1330'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8733 : proportional to */</span></div><div class='line' id='LC1331'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;infin&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8734&quot;</span><span class="p">;</span></div><div class='line' id='LC1332'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8734 : infinity */</span></div><div class='line' id='LC1333'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ang&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8736&quot;</span><span class="p">;</span></div><div class='line' id='LC1334'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8736 : angle */</span></div><div class='line' id='LC1335'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;and&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8743&quot;</span><span class="p">;</span></div><div class='line' id='LC1336'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8743 : logical and */</span></div><div class='line' id='LC1337'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;or&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8744&quot;</span><span class="p">;</span></div><div class='line' id='LC1338'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8744 : logical or */</span></div><div class='line' id='LC1339'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;cap&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8745&quot;</span><span class="p">;</span></div><div class='line' id='LC1340'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8745 : intersection */</span></div><div class='line' id='LC1341'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;cup&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8746&quot;</span><span class="p">;</span></div><div class='line' id='LC1342'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8746 : union */</span></div><div class='line' id='LC1343'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;int&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8747&quot;</span><span class="p">;</span></div><div class='line' id='LC1344'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8747 : integral */</span></div><div class='line' id='LC1345'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;there4&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8756&quot;</span><span class="p">;</span></div><div class='line' id='LC1346'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8756 : therefore */</span></div><div class='line' id='LC1347'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sim&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8764&quot;</span><span class="p">;</span></div><div class='line' id='LC1348'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8764 : tilde operator */</span></div><div class='line' id='LC1349'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;cong&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8773&quot;</span><span class="p">;</span></div><div class='line' id='LC1350'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8773 : congruent to */</span></div><div class='line' id='LC1351'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;asymp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8776&quot;</span><span class="p">;</span></div><div class='line' id='LC1352'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8776 : almost equal to */</span></div><div class='line' id='LC1353'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ne&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8800&quot;</span><span class="p">;</span></div><div class='line' id='LC1354'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8800 : not equal to */</span></div><div class='line' id='LC1355'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;equiv&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8801&quot;</span><span class="p">;</span></div><div class='line' id='LC1356'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8801 : identical to, equivalent to */</span></div><div class='line' id='LC1357'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;le&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8804&quot;</span><span class="p">;</span></div><div class='line' id='LC1358'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8804 : less-than or equal to */</span></div><div class='line' id='LC1359'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;ge&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8805&quot;</span><span class="p">;</span></div><div class='line' id='LC1360'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8805 : greater-than or equal to */</span></div><div class='line' id='LC1361'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sub&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8834&quot;</span><span class="p">;</span></div><div class='line' id='LC1362'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8834 : subset of */</span></div><div class='line' id='LC1363'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sup&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8835&quot;</span><span class="p">;</span></div><div class='line' id='LC1364'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8835 : superset of */</span></div><div class='line' id='LC1365'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;nsub&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8836&quot;</span><span class="p">;</span></div><div class='line' id='LC1366'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8836 : not a subset of */</span></div><div class='line' id='LC1367'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sube&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8838&quot;</span><span class="p">;</span></div><div class='line' id='LC1368'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8838 : subset of or equal to */</span></div><div class='line' id='LC1369'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;supe&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8839&quot;</span><span class="p">;</span></div><div class='line' id='LC1370'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8839 : superset of or equal to */</span></div><div class='line' id='LC1371'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;oplus&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8853&quot;</span><span class="p">;</span></div><div class='line' id='LC1372'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8853 : circled plus */</span></div><div class='line' id='LC1373'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;otimes&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8855&quot;</span><span class="p">;</span></div><div class='line' id='LC1374'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8855 : circled times */</span></div><div class='line' id='LC1375'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;perp&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8869&quot;</span><span class="p">;</span></div><div class='line' id='LC1376'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8869 : up tack */</span></div><div class='line' id='LC1377'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;sdot&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8901&quot;</span><span class="p">;</span></div><div class='line' id='LC1378'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8901 : dot operator */</span></div><div class='line' id='LC1379'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lceil&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8968&quot;</span><span class="p">;</span></div><div class='line' id='LC1380'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8968 : left ceiling */</span></div><div class='line' id='LC1381'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rceil&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8969&quot;</span><span class="p">;</span></div><div class='line' id='LC1382'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8969 : right ceiling */</span></div><div class='line' id='LC1383'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lfloor&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8970&quot;</span><span class="p">;</span></div><div class='line' id='LC1384'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8970 : left floor */</span></div><div class='line' id='LC1385'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rfloor&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;8971&quot;</span><span class="p">;</span></div><div class='line' id='LC1386'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 8971 : right floor */</span></div><div class='line' id='LC1387'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;lang&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;9001&quot;</span><span class="p">;</span></div><div class='line' id='LC1388'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 9001 : left-pointing angle bracket */</span></div><div class='line' id='LC1389'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;rang&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;9002&quot;</span><span class="p">;</span></div><div class='line' id='LC1390'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 9002 : right-pointing angle bracket */</span></div><div class='line' id='LC1391'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;loz&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;9674&quot;</span><span class="p">;</span></div><div class='line' id='LC1392'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 9674 : lozenge */</span></div><div class='line' id='LC1393'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;spades&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;9824&quot;</span><span class="p">;</span></div><div class='line' id='LC1394'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 9824 : black spade suit */</span></div><div class='line' id='LC1395'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;clubs&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;9827&quot;</span><span class="p">;</span></div><div class='line' id='LC1396'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 9827 : black club suit */</span></div><div class='line' id='LC1397'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;hearts&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;9829&quot;</span><span class="p">;</span></div><div class='line' id='LC1398'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 9829 : black heart suit */</span></div><div class='line' id='LC1399'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="s2">&quot;&amp;diams&quot;</span><span class="p">]</span> <span class="o">=</span> <span class="s2">&quot;9830&quot;</span><span class="p">;</span></div><div class='line' id='LC1400'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* 9830 : black diamond suit */</span></div><div class='line' id='LC1401'><br/></div><div class='line' id='LC1402'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">entity</span> <span class="k">in</span> <span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC1403'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="p">(</span><span class="k">typeof</span> <span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="nx">entity</span><span class="p">]</span> <span class="o">==</span> <span class="s1">&#39;function&#39;</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">.</span><span class="nx">hasOwnProperty</span><span class="p">(</span><span class="nx">entity</span><span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC1404'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">MAP_CHAR_TO_ENTITY</span><span class="p">[</span><span class="nx">MAP_ENTITY_TO_CHAR</span><span class="p">[</span><span class="nx">entity</span><span class="p">]]</span> <span class="o">=</span> <span class="nx">entity</span><span class="p">;</span></div><div class='line' id='LC1405'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC1406'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC1407'><br/></div><div class='line' id='LC1408'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="kd">var</span> <span class="nx">c</span> <span class="k">in</span> <span class="nx">MAP_CHAR_TO_ENTITY</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC1409'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="o">!</span><span class="p">(</span><span class="k">typeof</span> <span class="nx">MAP_CHAR_TO_ENTITY</span><span class="p">[</span><span class="nx">c</span><span class="p">]</span> <span class="o">==</span> <span class="s1">&#39;function&#39;</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nx">MAP_CHAR_TO_ENTITY</span><span class="p">.</span><span class="nx">hasOwnProperty</span><span class="p">(</span><span class="nx">c</span><span class="p">)</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC1410'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">ent</span> <span class="o">=</span> <span class="nx">MAP_CHAR_TO_ENTITY</span><span class="p">[</span><span class="nx">c</span><span class="p">].</span><span class="nx">toLowerCase</span><span class="p">().</span><span class="nx">substr</span><span class="p">(</span><span class="mi">1</span><span class="p">);</span></div><div class='line' id='LC1411'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">ENTITY_TO_CHAR_TRIE</span><span class="p">.</span><span class="nx">put</span><span class="p">(</span><span class="nx">ent</span><span class="p">,</span><span class="nb">String</span><span class="p">.</span><span class="nx">fromCharCode</span><span class="p">(</span><span class="nx">c</span><span class="p">));</span></div><div class='line' id='LC1412'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC1413'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC1414'><br/></div><div class='line' id='LC1415'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">})();</span></div><div class='line' id='LC1416'><br/></div><div class='line' id='LC1417'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// If ES5 Enabled Browser - Lock the encoder down as much as possible</span></div><div class='line' id='LC1418'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">freeze</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC1419'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span> <span class="o">=</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">freeze</span><span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">);</span></div><div class='line' id='LC1420'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">encode</span> <span class="o">=</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">freeze</span><span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">encode</span><span class="p">);</span></div><div class='line' id='LC1421'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">seal</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC1422'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span> <span class="o">=</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">seal</span><span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">);</span></div><div class='line' id='LC1423'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">encode</span> <span class="o">=</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">seal</span><span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">encode</span><span class="p">);</span></div><div class='line' id='LC1424'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">preventExtensions</span> <span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC1425'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span> <span class="o">=</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">preventExtensions</span><span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">encoder</span><span class="p">);</span></div><div class='line' id='LC1426'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">encode</span> <span class="o">=</span> <span class="nb">Object</span><span class="p">.</span><span class="nx">preventExtensions</span><span class="p">(</span><span class="nx">$</span><span class="p">.</span><span class="nx">fn</span><span class="p">.</span><span class="nx">encode</span><span class="p">);</span></div><div class='line' id='LC1427'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC1428'><span class="p">})(</span><span class="nx">jQuery</span><span class="p">);</span></div></pre></div>
              
            
          </td>
        </tr>
      </table>
    
  </div>


          </div>
        </div>
      </div>
    </div>
  

  </div>


<div class="frame frame-loading" style="display:none;">
  <img src="https://a248.e.akamai.net/assets.github.com/images/modules/ajax/big_spinner_336699.gif" height="32" width="32">
</div>

    </div>
  
      
    </div>

    <!--**************
     FOOTER
     **************-->
    <div id="footer" >
      <div class="upper_footer">
        <div class="site" class="clearfix">

        <!--[if IE]><h4 id="blacktocat_ie">GitHub Links</h4><![endif]-->
        <![if !IE]><h4 id="blacktocat">GitHub Links</h4><![endif]>

        <ul class="footer_nav">
          <h4>GitHub</h4>
          <li><a href="https://github.com/about">About</a></li>
          <li><a href="https://github.com/blog">Blog</a></li>
          <li><a href="https://github.com/contact">Contact &amp; Support</a></li>
          <li><a href="https://github.com/training">Training</a></li>
          <li><a href="http://status.github.com/">Site Status</a></li>
        </ul>

        <ul class="footer_nav">
          <h4>Tools</h4>
          <li><a href="http://mac.github.com/">GitHub for Mac</a></li>
          <li><a href="https://gist.github.com">Gist</a></li>
          <li><a href="http://fi.github.com/">Enterprise Install</a></li>
          <li><a href="http://jobs.github.com/">Job Board</a></li>
        </ul>

        <ul class="footer_nav">
          <h4>Extras</h4>
          <li><a href="http://shop.github.com/">Shop</a></li>
          <li><a href="http://octodex.github.com/">The Octodex</a></li>
        </ul>

        <ul class="footer_nav">
          <h4>Documentation</h4>
          <li><a href="http://help.github.com/">GitHub Help</a></li>
          <li><a href="http://developer.github.com/">Developer API</a></li>
          <li><a href="http://github.github.com/github-flavored-markdown/">GitHub Flavored Markdown</a></li>
          <li><a href="http://pages.github.com/">GitHub Pages</a></li>
        </ul>

        </div><!-- /.site -->
      </div><!-- /.upper_footer -->

      <div class="lower_footer">
        <div class="site" class="clearfix">

        <!--[if IE]><div id="legal_ie"><![endif]-->
        <![if !IE]><div id="legal"><![endif]>
              <ul>
                <li><a href="https://github.com/site/terms">Terms of Service</a></li>
                <li><a href="https://github.com/site/privacy">Privacy</a></li>
                <li><a href="https://github.com/security">Security</a></li>
              </ul>

              <p>&copy; 2011 <span id="_rrt" title="0.07005s from fe3.rs.github.com">GitHub</span> Inc. All rights reserved.</p>
            </div><!-- /#legal or /#legal_ie-->

          
          <div class="sponsor">
              <a href="http://www.rackspace.com" class="logo">
                <img alt="Dedicated Server" height="36" src="https://a248.e.akamai.net/assets.github.com/images/modules/footer/rackspace_logo.png?v2" width="38" />
              </a>
              Powered by the <a href="http://www.rackspace.com ">Dedicated
              Servers</a> and<br/> <a href="http://www.rackspacecloud.com">Cloud
              Computing</a> of Rackspace Hosting<span>&reg;</span>
          </div>
          
        </div><!-- /.site -->
      </div><!-- /.lower_footer -->
    </div><!-- /#footer -->

    

<div id="keyboard_shortcuts_pane" class="instapaper_ignore readability-extra" style="display:none">
  <h2>Keyboard Shortcuts <small><a href="#" class="js-see-all-keyboard-shortcuts">(see all)</a></small></h2>

  <div class="columns threecols">
    <div class="column first">
      <h3>Site wide shortcuts</h3>
      <dl class="keyboard-mappings">
        <dt>s</dt>
        <dd>Focus site search</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>?</dt>
        <dd>Bring up this help dialog</dd>
      </dl>
    </div><!-- /.column.first -->

    <div class="column middle" style='display:none'>
      <h3>Commit list</h3>
      <dl class="keyboard-mappings">
        <dt>j</dt>
        <dd>Move selected down</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>k</dt>
        <dd>Move selected up</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>t</dt>
        <dd>Open tree</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>p</dt>
        <dd>Open parent</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>c <em>or</em> o <em>or</em> enter</dt>
        <dd>Open commit</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>y</dt>
        <dd>Expand URL to its canonical form</dd>
      </dl>
    </div><!-- /.column.first -->

    <div class="column last" style='display:none'>
      <h3>Pull request list</h3>
      <dl class="keyboard-mappings">
        <dt>j</dt>
        <dd>Move selected down</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>k</dt>
        <dd>Move selected up</dd>
      </dl>
      <dl class="keyboard-mappings">
        <dt>o <em>or</em> enter</dt>
        <dd>Open issue</dd>
      </dl>
    </div><!-- /.columns.last -->

  </div><!-- /.columns.equacols -->

  <div style='display:none'>
    <div class="rule"></div>

    <h3>Issues</h3>

    <div class="columns threecols">
      <div class="column first">
        <dl class="keyboard-mappings">
          <dt>j</dt>
          <dd>Move selected down</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>k</dt>
          <dd>Move selected up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>x</dt>
          <dd>Toggle select target</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>o <em>or</em> enter</dt>
          <dd>Open issue</dd>
        </dl>
      </div><!-- /.column.first -->
      <div class="column middle">
        <dl class="keyboard-mappings">
          <dt>I</dt>
          <dd>Mark selected as read</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>U</dt>
          <dd>Mark selected as unread</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>e</dt>
          <dd>Close selected</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>y</dt>
          <dd>Remove selected from view</dd>
        </dl>
      </div><!-- /.column.middle -->
      <div class="column last">
        <dl class="keyboard-mappings">
          <dt>c</dt>
          <dd>Create issue</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>l</dt>
          <dd>Create label</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>i</dt>
          <dd>Back to inbox</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>u</dt>
          <dd>Back to issues</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>/</dt>
          <dd>Focus issues search</dd>
        </dl>
      </div>
    </div>
  </div>

  <div style='display:none'>
    <div class="rule"></div>

    <h3>Network Graph</h3>
    <div class="columns equacols">
      <div class="column first">
        <dl class="keyboard-mappings">
          <dt><span class="badmono">←</span> <em>or</em> h</dt>
          <dd>Scroll left</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">→</span> <em>or</em> l</dt>
          <dd>Scroll right</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">↑</span> <em>or</em> k</dt>
          <dd>Scroll up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt><span class="badmono">↓</span> <em>or</em> j</dt>
          <dd>Scroll down</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>t</dt>
          <dd>Toggle visibility of head labels</dd>
        </dl>
      </div><!-- /.column.first -->
      <div class="column last">
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">←</span> <em>or</em> shift h</dt>
          <dd>Scroll all the way left</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">→</span> <em>or</em> shift l</dt>
          <dd>Scroll all the way right</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">↑</span> <em>or</em> shift k</dt>
          <dd>Scroll all the way up</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>shift <span class="badmono">↓</span> <em>or</em> shift j</dt>
          <dd>Scroll all the way down</dd>
        </dl>
      </div><!-- /.column.last -->
    </div>
  </div>

  <div >
    <div class="rule"></div>
    <div class="columns threecols">
      <div class="column first" >
        <h3>Source Code Browsing</h3>
        <dl class="keyboard-mappings">
          <dt>t</dt>
          <dd>Activates the file finder</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>l</dt>
          <dd>Jump to line</dd>
        </dl>
        <dl class="keyboard-mappings">
          <dt>y</dt>
          <dd>Expand URL to its canonical form</dd>
        </dl>
      </div>
    </div>
  </div>
</div>

    <div id="markdown-help" class="instapaper_ignore readability-extra">
  <h2>Markdown Cheat Sheet</h2>

  <div class="cheatsheet-content">

  <div class="mod">
    <div class="col">
      <h3>Format Text</h3>
      <p>Headers</p>
      <pre>
# This is an &lt;h1&gt; tag
## This is an &lt;h2&gt; tag
###### This is an &lt;h6&gt; tag</pre>
     <p>Text styles</p>
     <pre>
*This text will be italic*
_This will also be italic_
**This text will be bold**
__This will also be bold__

*You **can** combine them*
</pre>
    </div>
    <div class="col">
      <h3>Lists</h3>
      <p>Unordered</p>
      <pre>
* Item 1
* Item 2
  * Item 2a
  * Item 2b</pre>
     <p>Ordered</p>
     <pre>
1. Item 1
2. Item 2
3. Item 3
   * Item 3a
   * Item 3b</pre>
    </div>
    <div class="col">
      <h3>Miscellaneous</h3>
      <p>Images</p>
      <pre>
![GitHub Logo](/images/logo.png)
Format: ![Alt Text](url)
</pre>
     <p>Links</p>
     <pre>
http://github.com - automatic!
[GitHub](http://github.com)</pre>
<p>Blockquotes</p>
     <pre>
As Kanye West said:
> We're living the future so
> the present is our past.
</pre>
    </div>
  </div>
  <div class="rule"></div>

  <h3>Code Examples in Markdown</h3>
  <div class="col">
      <p>Syntax highlighting with <a href="http://github.github.com/github-flavored-markdown/" title="GitHub Flavored Markdown" target="_blank">GFM</a></p>
      <pre>
```javascript
function fancyAlert(arg) {
  if(arg) {
    $.facebox({div:'#foo'})
  }
}
```</pre>
    </div>
    <div class="col">
      <p>Or, indent your code 4 spaces</p>
      <pre>
Here is a Python code example
without syntax highlighting:

    def foo:
      if not bar:
        return true</pre>
    </div>
    <div class="col">
      <p>Inline code for comments</p>
      <pre>
I think you should use an
`&lt;addr&gt;` element here instead.</pre>
    </div>
  </div>

  </div>
</div>
    

    <!--[if IE 8]>
    <script type="text/javascript" charset="utf-8">
      $(document.body).addClass("ie8")
    </script>
    <![endif]-->

    <!--[if IE 7]>
    <script type="text/javascript" charset="utf-8">
      $(document.body).addClass("ie7")
    </script>
    <![endif]-->

    
    
    
    <script type="text/javascript">(function(){var d=document;var e=d.createElement("script");e.async=true;e.src="https://d1ros97qkrwjf5.cloudfront.net/14/eum/rum.js	";e.type="text/javascript";var s=d.getElementsByTagName("script")[0];s.parentNode.insertBefore(e,s);})();NREUMQ.push(["nrf2","beacon-1.newrelic.com","2f94e4d8c2",64799,"dw1bEBZcX1RWRhoEClsAGhcMXEQ=",0.0,70,new Date().getTime()])</script>
  </body>
</html>

