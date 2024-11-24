package Discordbot.eventListener;

import org.bukkit.Bukkit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chat")
public class Api {
    // TODO: Figure out how to make this work
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addChat(Data data) {
        Bukkit.getServer().broadcastMessage(data.toString());
        return Response.status(Response.Status.CREATED).build();
    }

}