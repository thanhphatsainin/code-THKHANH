///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controller.TrangChu;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Properties;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author DELL
// */
//public class sendMail extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        
//        String mailCus = request.getParameter("mailCus");
//        try (PrintWriter out = response.getWriter()) {
//            
//            SendAction(mailCus);
//            //request.setAttribute("listToy", list);
//            String url = request.getContextPath()+"/index.jsp";
//            RequestDispatcher view = request.getRequestDispatcher(url);
//            view.forward(request, response);
//        }
//    }
//    
//    private void SendAction(String mailCus) {
//        String username = "nampro101099@gmail.com";
//        String pass = "01685025249bomay";
//        String[] listTo = getListEmail(mailCus);
//        String[] listCc = getListEmail(mailCus);
//        String[] listBcc = getListEmail(mailCus);
//        String filePath = "";
//        String mess = "Ban da dang ky nhan khuyen mai!";
//        String subject = "ENOVAL";
//        Session sess = Login(username, pass);
//        Send sender = new Send(sess);
//        System.out.println(filePath);
//        sender.sendEmail(listTo, listCc, listBcc, mess, filePath, subject);
//    }
//    
//    public static Session Login(String username, String pass) {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.host", MailConfig.HostSend);
//        props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.port", MailConfig.SSL_PORT);
//
//        System.out.println("SSLEmail Start");
//        
//
//        PasswordAuthentication Auth = new PasswordAuthentication(username, pass);
//        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return Auth;
//            }
//        });
//        return session;
//    }
//    
//    private String[] getListEmail(String str) {
//        if (str.equals("")) {
//            return null;
//        } else if (!str.contains(",")) {
//            String[] strArr = {str};
//            return strArr;
//        }
//        return str.split(",");
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
