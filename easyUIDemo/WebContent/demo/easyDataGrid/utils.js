/**
 * Created by Jquery on 2017/12/30.
 */
function getRootPath()
{
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return webName;
}
